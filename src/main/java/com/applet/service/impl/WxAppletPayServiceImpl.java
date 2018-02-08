package com.applet.service.impl;

import com.applet.annotation.SystemServerLog;
import com.applet.entity.WxPay.WxAppletPayRequest;
import com.applet.entity.WxPay.WxAppletPayResponse;
import com.applet.enums.ResultEnums;
import com.applet.mapper.AmountRecordMapper;
import com.applet.model.AmountRecord;
import com.applet.service.WxAppleetPayService;
import com.applet.utils.AppletResult;
import com.applet.utils.ResultUtil;
import com.applet.utils.WxAppletServiceUtil;
import com.applet.utils.common.JSONUtil;
import com.applet.utils.common.UuidUtil;
import com.applet.utils.common.XmlOrMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class WxAppletPayServiceImpl implements WxAppleetPayService {


    @Autowired
    private WxAppletServiceUtil wcxServiceUtil;

    @Autowired
    private AmountRecordMapper amountRecordMapper;


    /**
     * 微信小程序支付
     *
     * @param wxAppletPayRequest
     * @return
     */
    @SystemServerLog(funcionExplain = "微信支付")
    @Override
    public AppletResult appletPay(WxAppletPayRequest wxAppletPayRequest) throws Exception {

        Map<String,Object> params=new HashMap<>();
        params.put("body",wxAppletPayRequest.getModeName());
        params.put("total_fee",wxAppletPayRequest.getAmount());
        params.put("spbill_create_ip",wxAppletPayRequest.getUserHost());
        params.put("openid",wxAppletPayRequest.getOpenId());
        long outTradeNo = Long.parseLong((System.currentTimeMillis() + UuidUtil
                .getThreeDigits(100)));
        params.put("out_trade_no",outTradeNo);
        String result = wcxServiceUtil.SendRequestToWcx(params);
        Map<String, String> map = XmlOrMapUtils.xmlToMap(result);
        if (map.get("return_code").equals("FAIL")){
            return ResultUtil.error(ResultEnums.WX_PLAY_FAIL);
        }

        WxAppletPayResponse wxAppletPayResponse = JSONUtil.parseObject(JSONUtil.toJSONString(map), WxAppletPayResponse.class);


        Map<String,Object> requestPayment=new HashMap<>();
        requestPayment.put("nonceStr",wxAppletPayResponse.getNonce_str());
        StringBuffer sbuffer=new StringBuffer("prepay_id");
        requestPayment.put("package",sbuffer.append("=").append(wxAppletPayResponse.getPrepay_id()));
        requestPayment.put("signType","MD5");
        requestPayment.put("timeStamp",new Date().getTime());
        String paySign = WxAppletServiceUtil.generateSign(requestPayment);
        requestPayment.put("paySign",paySign);
        AmountRecord amountRecord=new AmountRecord();
        amountRecord.setId(UuidUtil.getUuid());
        amountRecord.setRechargeId(new BigDecimal(outTradeNo));
        amountRecord.setAmount(new BigDecimal(wxAppletPayRequest.getAmount()));
        amountRecord.setUserId(wxAppletPayRequest.getAdminId());
        amountRecord.setAliUserId(wxAppletPayRequest.getOpenId());
        amountRecord.setRechargeWay(1);
        amountRecordMapper.insertSelective(amountRecord);
        return ResultUtil.success(requestPayment);
    }
}
