package com.applet.service.impl;

import com.applet.annotation.SystemServerLog;
import com.applet.entity.AliPayInfo;
import com.applet.entity.PayBackStatusNotice;
import com.applet.entity.WxPayInfo;
import com.applet.enums.ResultEnums;
import com.applet.enums.WxCallBackResultEnums;
import com.applet.mapper.CustomerOrderInfoMapper;
import com.applet.model.BaseOrderInfo;
import com.applet.model.CustomerOrderInfo;
import com.applet.service.OrderStatusUpdateService;
import com.applet.service.WxPayService;
import com.applet.utils.AppletResult;
import com.applet.utils.HttpClient.HttpApiUtils;
import com.applet.utils.ResultUtil;
import com.applet.utils.common.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class WxPayServiceImpl implements WxPayService {

    private static BigDecimal bigDecimal = new BigDecimal(100);

    private static Logger LOGGER = LoggerFactory.getLogger(WxPayServiceImpl.class);


    //支付回调成功
    private static Map<String,String> BACK_SUCCESS=WxCallBackResultEnums.returnCallResult(WxCallBackResultEnums.CALL_BACK_NOTIFY_SUCCESS);

    //支付回调业务结果失败
    private static Map<String,String> BACK_BUSINESS_FAIL=WxCallBackResultEnums.returnCallResult(WxCallBackResultEnums.CALL_BACK_BUSINESS_FAIL);

    //支付回调通信失败
    private static Map<String,String> BACK_NOTIFY_FAIL=WxCallBackResultEnums.returnCallResult(WxCallBackResultEnums.CALL_BACK_NOTIFY_FAIL);

    //支付回调签名验证失败
    private static Map<String,String> BACK_SIGIN_FAIL=WxCallBackResultEnums.returnCallResult(WxCallBackResultEnums.CALL_BACK_NOTIFY_SIGIN_FAIL);


    @Autowired
    private WxPayInfo wxPayInfo;

    @Autowired
    private PayBackStatusNotice payBackStatusNotice;


    /**
     * 微信支付接口
     *
     * @return
     */
    @SystemServerLog(funcionExplain = "微信支付服务")
    @Override
    public AppletResult pay(CustomerOrderInfo orderInfo) {

        try {

            Map<String, String> resultMap = getPrePayId(orderInfo, wxPayInfo);

            if (WxPayInfo.CALL_BACK_SUCCESS.equals(resultMap.get("result_code"))) {
                Map<String, String> hashMap = new HashMap<>();
                hashMap.put("appid", wxPayInfo.getAppId());
                hashMap.put("partnerid", wxPayInfo.getMchId());
                hashMap.put("package", wxPayInfo.getPackageSign());
                hashMap.put("prepayid", resultMap.get("prepay_id"));
                hashMap.put("noncestr", resultMap.get("nonce_str"));
                hashMap.put("timestamp", String.valueOf(new Date().getTime()));

                String paySign = MapToUrlUtils.formatUrlMap(hashMap, false,
                        false);
                StringBuilder signStr = new StringBuilder(Md5Util.MD5(paySign));
                String sign = signStr.append("&key=").append(wxPayInfo.getKey()).toString();
                hashMap.put("sign", sign);
            } else {

                LOGGER.error("微信预下单ERROR  err_code -->{}  err_code_des --> {}", resultMap.get("err_code"), resultMap.get("err_code_des"));

                return ResultUtil.error(ResultEnums.WX_PLAY_FAIL);
            }
        } catch (Exception e) {
            LOGGER.error("微信预下单系统ERROR {}", e.getMessage());

        }
        return null;
    }

    /**
     * 微信支付回调
     *
     * @param request
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @SystemServerLog(funcionExplain = "微信支付回调服务")
    @Override
    public String payBack(HttpServletRequest request) {


        try {

            String xml = StreamUtil.inputStream2String(request.getInputStream(), "UTF-8");
            Map<String, String> xmlToMap = XmlOrMapUtils.xmlToMap(xml);
            LOGGER.debug("微信支付回调参数 --> {}",JSONUtil.toJSONString(xmlToMap));

            StringBuilder sign = new StringBuilder(Md5Util.MD5(MapToUrlUtils.formatUrlMap(xmlToMap, false,
                    false)));


            if (!sign.toString().equals(xmlToMap.get("sign"))) {
                LOGGER.debug("微信签名 --> {}",sign);
                return JSONUtil.toJSONString(BACK_SIGIN_FAIL);
            }

            // 通信是否成功
            if (WxPayInfo.CALL_BACK_SUCCESS.equals(xmlToMap.get("return_code"))) {

                // 交易是否成功
                if (WxPayInfo.CALL_BACK_SUCCESS.equals(xmlToMap.get("result_code"))) {

                    StringBuilder orderNumber = new StringBuilder(xmlToMap.get("out_trade_no"));

                    StringBuilder openId = new StringBuilder(xmlToMap.get("openid"));



                    boolean status = payBackStatusNotice.isPayStatusSuccess(Long.parseLong(orderNumber.toString()));

                    // 查看订单状态是否已经更新成支付成功
                    if (status) {
                        return JSONUtil.toJSONString(BACK_SUCCESS);
                    }

                    //更新支付状态为成功
                    BaseOrderInfo baseOrderInfo=new BaseOrderInfo(orderNumber.toString(),openId.toString());
                    payBackStatusNotice.updatePaySuccessStatus(baseOrderInfo);

                    return JSONUtil.toJSONString(BACK_SUCCESS);
                } else {
                    return JSONUtil.toJSONString(BACK_BUSINESS_FAIL);
                }
            } else {
                return JSONUtil.toJSONString(BACK_NOTIFY_FAIL);
            }

        } catch (Exception e) {
            LOGGER.error("微信支付回调", e);

        }
        return null;
    }


    /**
     * 微信预支付
     *
     * @param orderInfo
     * @param wxPayInfo
     * @return
     */
    private Map<String, String> getPrePayId(CustomerOrderInfo orderInfo,
                                            WxPayInfo wxPayInfo) {
        try {
            Map<String, String> m = new HashMap<>();
            m.put("appid", wxPayInfo.getAppId());
            m.put("mch_id", wxPayInfo.getMchId());
            m.put("nonce_str", UuidUtil.getUuid());
            m.put("out_trade_no", orderInfo.getOrderNumber());
            m.put("total_fee", BigDecimalUtil.multiply(orderInfo.getPayAmount(), bigDecimal).toString());
            m.put("spbill_create_ip", WxPayInfo.SPBILL_CREATE_IP);
            m.put("notify_url", wxPayInfo.getPayBackUrl());
            m.put("trade_type", WxPayInfo.TRADE_TYPE);
            String stringA = MapToUrlUtils.formatUrlMap(m, false, false);
            StringBuilder signStr = new StringBuilder(stringA);
            String stringSignTemp = signStr.append("&key=").append(wxPayInfo.getKey()).toString(); // 注：key为商户平台设置的密钥key
            m.put("sign", Md5Util.MD5(stringSignTemp));
            String reqResult = HttpApiUtils.sendRequest(WxPayInfo.WX_PAY_URL, XmlOrMapUtils.mapToXml(m));
            return XmlOrMapUtils.xmlToMap(reqResult);
        } catch (Exception e) {
            LOGGER.error("微信预支付ERROR {}", e.getMessage());
        }
        return null;
    }
}
