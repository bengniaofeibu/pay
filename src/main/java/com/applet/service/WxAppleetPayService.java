package com.applet.service;

import com.applet.entity.WxPay.WxAppletPayCallBack;
import com.applet.entity.WxPay.WxAppletPayRequest;
import com.applet.utils.AppletResult;

public interface WxAppleetPayService {

    /**
     * 微信小程序支付
     * @param request
     * @return
     */
    AppletResult appletPay(WxAppletPayRequest request) throws Exception;
}
