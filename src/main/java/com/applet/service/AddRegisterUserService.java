package com.applet.service;

import com.applet.model.UserInfo;
import com.applet.model.WxUserInfo;

public interface AddRegisterUserService {

    /**
     * 添加注册信息
     * @param userInfo
     * @param wxUserInfo
     */
    UserInfo addRegisterUser(UserInfo userInfo,WxUserInfo wxUserInfo);
}
