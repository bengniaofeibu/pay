package com.applet.service;

import com.applet.utils.AppletResult;

public interface CustomerInfoService {

    /**
     * 获取客户地址
     * @param userId
     * @return
     */
    AppletResult getCustomerAddress(String userId);
}
