package com.applet.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.applet.Request.UserPayReq;
import com.applet.annotation.SystemServerLog;
import com.applet.entity.PayBackStatusNotice;
import com.applet.entity.WxPayInfo;
import com.applet.enums.ResultEnums;
import com.applet.enums.WxCallBackResultEnums;
import com.applet.mapper.AmountRecordMapper;
import com.applet.mapper.BicycleWxUserInfoMapper;
import com.applet.mapper.UserInfoMapper;
import com.applet.mapper.UserTransLogMapper;
import com.applet.model.AmountRecord;
import com.applet.model.BaseOrderInfo;
import com.applet.model.UserInfo;
import com.applet.model.UserTransLog;
import com.applet.service.StoreOrderUpdateService;
import com.applet.service.WxPayService;
import com.applet.utils.AppletResult;
import com.applet.utils.HttpClient.HttpApiUtils;
import com.applet.utils.ResultUtil;
import com.applet.utils.common.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class WxPayServiceImpl implements WxPayService {

    private static BigDecimal BIGDECIMAL = new BigDecimal(100);

    private static Logger LOGGER = LoggerFactory.getLogger(WxPayServiceImpl.class);


    //支付回调成功
    private static Map<String, String> BACK_SUCCESS = WxCallBackResultEnums.returnCallResult(WxCallBackResultEnums.CALL_BACK_NOTIFY_SUCCESS);

    //支付回调业务结果失败
    private static Map<String, String> BACK_BUSINESS_FAIL = WxCallBackResultEnums.returnCallResult(WxCallBackResultEnums.CALL_BACK_BUSINESS_FAIL);

    //支付回调通信失败
    private static Map<String, String> BACK_NOTIFY_FAIL = WxCallBackResultEnums.returnCallResult(WxCallBackResultEnums.CALL_BACK_NOTIFY_FAIL);


    @Autowired
    private WxPayInfo wxPayInfo;

    @Autowired
    private PayBackStatusNotice payBackStatusNotice;

    @Autowired
    private StoreOrderUpdateService storeOrderUpdateService;

    @Autowired
    private BicycleWxUserInfoMapper wxUserInfoMapper;

    @Autowired
    private AmountRecordMapper amountRecordMapper;

    @Autowired
    private UserTransLogMapper userTransLogMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Value("${wxTransferReqUrl}")
    private String wxTransferReqUrl;

    private static final String WX_TRANSFER_CODE = "10000";

    /**
     * 微信支付接口
     *
     * @return
     */
    @SystemServerLog(funcionExplain = "微信支付服务")
    @Override
    public AppletResult pay(UserPayReq orderInfo) {

        try {

            Map<String, String> resultMap = getPrePayId(orderInfo, wxPayInfo);

            if (resultMap == null || resultMap.size() == 0) {
                return ResultUtil.error(ResultEnums.WX_PLAY_FAIL);
            }

            if (WxPayInfo.CALL_BACK_SUCCESS.equals(resultMap.get("result_code"))) {
                Map<String, String> hashMap = new HashMap<>();
                hashMap.put("appid", wxPayInfo.getAppId());
                hashMap.put("partnerid", wxPayInfo.getMchId());
                hashMap.put("package", wxPayInfo.getPackageSign());
                hashMap.put("prepayid", resultMap.get("prepay_id"));
                hashMap.put("noncestr", resultMap.get("nonce_str"));
                hashMap.put("timestamp", String.valueOf(SysCuTimeSecOfCNUtils.getSysCuTimeSecOfCN()));

                String paySign = MapToUrlUtils.formatUrlMap(hashMap, false,
                        false);
                StringBuilder signStr = new StringBuilder(paySign);
                String sign = signStr.append("&key=").append(wxPayInfo.getKey()).toString();
                hashMap.put("sign", Md5Util.MD5(sign));

                return ResultUtil.success(hashMap);
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
            LOGGER.debug("微信支付回调参数 --> {}", JSONUtil.toJSONString(xmlToMap));


            // 通信是否成功
            if (WxPayInfo.CALL_BACK_SUCCESS.equals(xmlToMap.get("return_code"))) {

                // 交易是否成功
                if (WxPayInfo.CALL_BACK_SUCCESS.equals(xmlToMap.get("result_code"))) {

                    StringBuilder orderNumber = new StringBuilder(xmlToMap.get("out_trade_no"));

                    StringBuilder openId = new StringBuilder(xmlToMap.get("openid"));

                    StringBuilder transactionId = new StringBuilder(xmlToMap.get("transaction_id"));

                    StringBuilder totalFee = new StringBuilder(xmlToMap.get("total_fee"));

                    BigDecimal totalAmount = BigDecimalUtil.divide(new BigDecimal(totalFee.toString()), BIGDECIMAL, 2);

                    boolean status = payBackStatusNotice.isPayStatusSuccess(orderNumber.toString());

                    // 查看订单状态是否已经更新成支付成功
                    if (status) {
                        return JSONUtil.toJSONString(BACK_SUCCESS);
                    }

                    //更新支付状态为成功
                    BaseOrderInfo baseOrderInfo = new BaseOrderInfo(totalAmount, (short) 1, orderNumber.toString(), openId.toString(), transactionId.toString());
                    payBackStatusNotice.updatePaySuccessStatus(storeOrderUpdateService, baseOrderInfo);

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
    private Map<String, String> getPrePayId(UserPayReq orderInfo,
                                            WxPayInfo wxPayInfo) {
        try {


            int amount = BigDecimalUtil.multiply(orderInfo.getPayAmount(), BIGDECIMAL).intValue();
            LOGGER.debug("微信实际支付金额 --> {}", amount);

            Map<String, String> m = new HashMap<>();
            m.put("body", orderInfo.getOrderSubject());
            m.put("appid", wxPayInfo.getAppId());
            m.put("mch_id", wxPayInfo.getMchId());
            m.put("nonce_str", UuidUtil.getUuid());
            m.put("out_trade_no", orderInfo.getOrderNumber());
            m.put("total_fee", String.valueOf(amount));
            m.put("spbill_create_ip", WxPayInfo.SPBILL_CREATE_IP);
            m.put("notify_url", wxPayInfo.getPayBackUrl());
            m.put("trade_type", WxPayInfo.TRADE_TYPE);
            String stringA = MapToUrlUtils.formatUrlMap(m, false, false);
            StringBuilder signStr = new StringBuilder(stringA);
            String stringSignTemp = signStr.append("&key=").append(wxPayInfo.getKey()).toString(); // 注：key为商户平台设置的密钥key
            m.put("sign", Md5Util.MD5(stringSignTemp));
            return WxUtils.wxUrl(WxPayInfo.WX_PAY_URL, m);
        } catch (Exception e) {
            LOGGER.error("微信预支付ERROR {}", e);
        }
        return null;
    }

    /**
     * 微信转账 企业到个人账户
     *
     * @param userPayReq
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @SystemServerLog(funcionExplain = "微信转账")
    @Override
    public AppletResult wxTransfer(UserPayReq userPayReq) {

        UserInfo userInfo = userInfoMapper.selectUserInfoByUserId(userPayReq.getUserId());

        if (userInfo != null) {

            if (userInfo.getAccountStatus() == 0 || userInfo.getAccountStatus() == 2) {
                return ResultUtil.error(ResultEnums.user_account_status_FAIL);
            }

        } else {
            return ResultUtil.error(ResultEnums.USER_NOT_FOUND_FAIL);
        }


        AmountRecord amountRecord = amountRecordMapper.selectOrderInfoByUserId(userPayReq.getUserId());
        LOGGER.debug("微信准备转账订单信息 {}",amountRecord);


        //判断该订单是否是提现异常状态
        if (amountRecord == null) {
            return ResultUtil.error(ResultEnums.ORDER_STATUS_ALREADY_COMPLETE);
        }

        //查询这笔订单是否已经有转账记录
        int count = userTransLogMapper.selectCountByOrderNo(amountRecord.getRechargeId().toString());

        if (count != 0 ){
            return ResultUtil.error(ResultEnums.ORDER_STATUS_ALREADY_COMPLETE);
        }

        //判断用户是否微信授权过
        String openId = wxUserInfoMapper.selectOpenIdByUserId(userPayReq.getUserId());

        //没有查询到用户的openId
        if (StringUtils.isBlank(openId)) {
            return ResultUtil.error(ResultEnums.USER_OPEN_ID_NOT_FOUND_FAIL);
        }

        Map<String, Object> sendMap = new HashMap<>();
        sendMap.put("rechargeId", amountRecord.getRechargeId());
        sendMap.put("amount", amountRecord.getAmount());
        sendMap.put("openId", openId);

        WxTransferRes wxTransferRes = HttpApiUtils.pSendResquestJson(wxTransferReqUrl, new JSONObject(sendMap), WxTransferRes.class);
        LOGGER.debug("微信企业转账到个人返回结果 {}", JSONUtil.toJSONString(wxTransferRes));

        if (wxTransferRes.getCode().equals(WX_TRANSFER_CODE)) {
            int updateNum = amountRecordMapper.updateOrderStateByRechargeId(new AmountRecord(amountRecord.getRechargeId(), 3, wxTransferRes.getData().toString()));
            LOGGER.debug("微信企业转账到个人订单更新状态 {}", updateNum);

            //记录用户转账信息
            userTransLogMapper.insertUserTransLog(new UserTransLog(userPayReq.getUserId(), amountRecord.getRechargeId().toString(), wxTransferRes.getData().toString(), (short) 1));

            if (updateNum > 0) {

                //转账成功后，修改用户状态为未缴纳押金的状态
                switch (userInfo.getAccountStatus()){
                    case 1:
                    userInfo.setAccountStatus(0);
                    break;
                    case 3:
                    userInfo.setAccountStatus(2);
                    break;
                    default:
                        LOGGER.error("用户状态异常 {}",userInfo.getAccountStatus());
                }

                userInfoMapper.updateUserAccountStatus(new UserInfo(userPayReq.getUserId(),userInfo.getAccountStatus()));
                return ResultUtil.success(ResultEnums.WX_TRANSFER_SUCCESS);
            } else {
                return ResultUtil.error(ResultEnums.ORDER_STATUS_UPDATE_FAIL);
            }
        } else {
            return ResultUtil.error(ResultEnums.WX_TRANSFER_FAIL);
        }
    }

    static class WxTransferRes {

        private String code;

        private String msg;

        private Object data;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
}
