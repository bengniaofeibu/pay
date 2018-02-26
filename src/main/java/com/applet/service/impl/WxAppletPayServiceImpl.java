package com.applet.service.impl;

import com.applet.annotation.SystemServerLog;
import com.applet.entity.WxPay.WxAppletPayCallBack;
import com.applet.entity.WxPay.WxAppletPayRequest;
import com.applet.entity.WxPay.WxAppletPayResponse;
import com.applet.entity.WxPay.WxRequestPayment;
import com.applet.enums.ResultEnums;
import com.applet.mapper.AmountRecordMapper;
import com.applet.mapper.UserInfoMapper;
import com.applet.mapper.WxUserInfoMapper;
import com.applet.model.AmountRecord;
import com.applet.model.UserInfo;
import com.applet.model.WxUserInfo;
import com.applet.service.WxAppleetPayService;
import com.applet.utils.AppletResult;
import com.applet.utils.ResultUtil;
import com.applet.utils.WxAppletServiceUtil;
import com.applet.utils.common.BaseUtil;
import com.applet.utils.common.JSONUtil;
import com.applet.utils.common.UuidUtil;
import com.applet.utils.common.XmlOrMapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class WxAppletPayServiceImpl implements WxAppleetPayService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WxAppletPayServiceImpl.class);

    @Autowired
    private WxAppletServiceUtil wcxServiceUtil;

    @Autowired
    private AmountRecordMapper amountRecordMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private WxUserInfoMapper wxUserInfoMapper;

    /**
     * 微信小程序支付
     *
     * @param wxAppletPayRequest
     * @return
     */
    @SystemServerLog(funcionExplain = "微信支付")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AppletResult appletPay(WxAppletPayRequest wxAppletPayRequest) throws Exception {

        Map<String, Object> params = new HashMap<>();
        params.put("body", wxAppletPayRequest.getModeName());
        params.put("total_fee", wxAppletPayRequest.getAmount());
        params.put("spbill_create_ip", wxAppletPayRequest.getUserHost());
        params.put("openid", wxAppletPayRequest.getOpenId());
        long outTradeNo = Long.parseLong((System.currentTimeMillis() + UuidUtil
                .getThreeDigits(100)));
        params.put("out_trade_no", outTradeNo);
        String result = wcxServiceUtil.SendRequestToWcx(params);
        Map<String, String> map = XmlOrMapUtils.xmlToMap(result);
        if (map.get("return_code").equals("FAIL")) {
            return ResultUtil.error(ResultEnums.WX_PLAY_FAIL);
        }

        WxAppletPayResponse wxAppletPayResponse = JSONUtil.parseObject(JSONUtil.toJSONString(map), WxAppletPayResponse.class);


        Map<String, Object> requestPayment = new HashMap<>();
        requestPayment.put("appId", WxAppletServiceUtil.APP_ID);
        requestPayment.put("nonceStr", BaseUtil.getRandomUUID());
        StringBuffer sbuffer = new StringBuffer("prepay_id");
        requestPayment.put("package", sbuffer.append("=").append(wxAppletPayResponse.getPrepay_id()));
        requestPayment.put("signType", "MD5");
        requestPayment.put("timeStamp", String.valueOf(new Date().getTime()));
        String paySign = WxAppletServiceUtil.generateSign(requestPayment);
        requestPayment.put("paySign", paySign.toUpperCase());
        AmountRecord amountRecord = new AmountRecord();
        amountRecord.setId(UuidUtil.getUuid());
        amountRecord.setRechargeId(new BigDecimal(outTradeNo));
        amountRecord.setAmount(new BigDecimal(wxAppletPayRequest.getAmount()));
        amountRecord.setUserId(wxAppletPayRequest.getAdminId());
        amountRecord.setAliUserId(wxAppletPayRequest.getOpenId());
        amountRecord.setRescoureId(2);
        amountRecord.setRechargeWay(1);
        amountRecordMapper.insertSelective(amountRecord);
        return ResultUtil.success(requestPayment);
    }
}
