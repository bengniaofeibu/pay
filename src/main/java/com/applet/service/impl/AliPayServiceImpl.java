package com.applet.service.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.applet.annotation.SystemServerLog;
import com.applet.entity.AliPayInfo;
import com.applet.entity.PayBackStatusNotice;
import com.applet.enums.ResultEnums;
import com.applet.mapper.CustomerOrderInfoMapper;
import com.applet.model.BaseOrderInfo;
import com.applet.model.CustomerOrderInfo;
import com.applet.service.AliPayService;
import com.applet.service.OrderStatusUpdateService;
import com.applet.utils.AppletResult;
import com.applet.utils.ResultUtil;
import com.applet.utils.common.JSONUtil;
import com.applet.utils.common.OrderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class AliPayServiceImpl implements AliPayService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AliPayServiceImpl.class);


    @Autowired
    private AliPayInfo aliPayNewInfo;

    @Autowired
    private PayBackStatusNotice payBackStatusNotice;


    /**
     * 阿里支付接口
     *
     * @return
     */
    @SystemServerLog(funcionExplain = "阿里支付服务")
    @Override
    public AppletResult pay(CustomerOrderInfo orderInfo) {

        //订单标题
        String orderSubject = orderInfo.getOrderSubject();

        //订单金额
        BigDecimal amount = orderInfo.getPayAmount();


        if (amount == null) {
            LOGGER.error("amount {}", amount, "null");
            return ResultUtil.error(ResultEnums.PARAM_IS_NULL);
        }

        try {

            StringBuilder amountStr = new StringBuilder(amount.toString());
            long payOrder = OrderUtil.generateOrderNumber();

            //实例化客户端
            AlipayClient alipayClient = new DefaultAlipayClient(AliPayInfo.ALI_PAY_URL, aliPayNewInfo.getAppId(),
                    aliPayNewInfo.getPrivateKey(), AliPayInfo.PAY_FORMAT, AliPayInfo.PAY_ENCODE,
                    aliPayNewInfo.getAppPublicKey(), AliPayInfo.PAY_SIGN_TYPE);

            AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
            AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
            model.setSubject(orderSubject);
            model.setOutTradeNo(String.valueOf(payOrder));
            model.setTimeoutExpress(AliPayInfo.PAY_WAIT_TIME);  //该笔订单允许的最晚付款时间，逾期将关闭交易
            model.setTotalAmount(amountStr.toString());
            model.setProductCode(AliPayInfo.QUICK_MSECURITY_PAY);
            request.setBizModel(model);
            request.setNotifyUrl(aliPayNewInfo.getPayBackUrl());

            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);

            return ResultUtil.success(ResultEnums.RETURN_SUCCESS, AliPayInfo.buildAliPayResult(response.getBody(), payOrder));
        } catch (Exception e) {
            LOGGER.error("阿里支付ERROR", e.getMessage());
            return ResultUtil.error(ResultEnums.SERVER_ERROR);
        }
    }

    /**
     * 支付回调
     *
     * @param request
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @SystemServerLog(funcionExplain = "阿里充值回调服务")
    @Override
    public String payBack(HttpServletRequest request) {

        try {

            Map<String, String> params = new HashMap<>();
            Map requestParams = request.getParameterMap();
            StringBuilder str;
            for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                str = new StringBuilder();
                for (int i = 0; i < values.length; i++) {
                    str = (i == values.length - 1) ? str.append(values[i])
                            : str.append(values[i]).append(",");
                }

                params.put(name, str.toString());
            }

            LOGGER.debug("支付宝回调参数 --> {}", JSONUtil.toJSONString(params));

            boolean signature = AlipaySignature.rsaCheckV1(params, aliPayNewInfo.getAppPublicKey(), AliPayInfo.PAY_ENCODE, AliPayInfo.PAY_SIGN_TYPE);
            LOGGER.debug("SIGNATURE -->{}", signature);
            if (signature) {

                StringBuilder orderNumber = new StringBuilder(params.get("out_trade_no"));//支付订单号

                StringBuilder aliTradeNo = new StringBuilder(params.get("trade_no"));//阿里订单号

                StringBuilder buyerId = new StringBuilder(params.get("buyer_id"));//用户支付宝唯一编号 2088开头

                StringBuilder tradeStatus = new StringBuilder(params.get("trade_status")); //支付状态

                if (!AliPayInfo.TRADE_SUCCESS.equalsIgnoreCase(tradeStatus.toString())) {
                    return AliPayInfo.RETURN_SUCCESS;
                }


                // 查看订单状态是否已经更新成支付成功
                boolean status = payBackStatusNotice.isPayStatusSuccess(Long.parseLong(orderNumber.toString()));

                if (status) {
                    return AliPayInfo.RETURN_SUCCESS;
                }

                //更新支付状态为成功
                BaseOrderInfo baseOrderInfo=new BaseOrderInfo(orderNumber.toString(),buyerId.toString(),aliTradeNo.toString());
                payBackStatusNotice.updatePaySuccessStatus(baseOrderInfo);


                return AliPayInfo.RETURN_SUCCESS;
            } else {
                return AliPayInfo.RETURN_FALSE;
            }
        } catch (Exception e) {
            LOGGER.error("阿里回调ERROR", e);
        }
        return AliPayInfo.RETURN_FALSE;
    }
}
