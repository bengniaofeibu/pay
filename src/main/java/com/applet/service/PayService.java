package com.applet.service;

import com.applet.Request.UserPayReq;
import com.applet.model.CustomerOrderInfo;
import com.applet.utils.AppletResult;

import javax.servlet.http.HttpServletRequest;

public interface PayService {

    /**
     * 支付接口
     * @return
     */
    AppletResult pay(UserPayReq customerOrderInfo);


    /**
     * 支付回调
     * @param request
     * @return
     */
    String payBack(HttpServletRequest request);

}
