package com.applet.service;

import com.applet.Request.UserPayReq;
import com.applet.utils.AppletResult;

public interface WxPayService extends PayService {

    /**
     * 微信转账 企业到个人账户
     * @param userPayReq
     * @return
     */
    AppletResult wxTransfer(UserPayReq userPayReq);
}
