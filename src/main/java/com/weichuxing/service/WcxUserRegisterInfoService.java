package com.weichuxing.service;

import com.weichuxing.entity.WcxRequest.WcxUserRegisterInfoRequest;

public interface WcxUserRegisterInfoService {

    /**
     * 操作微出行用户注册信息
     * @param wcxUserRegisterInfo
     */
    void notifyWcxUserRegisterInfo(WcxUserRegisterInfoRequest wcxUserRegisterInfo);


}
