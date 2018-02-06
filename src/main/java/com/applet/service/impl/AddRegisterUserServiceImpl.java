package com.applet.service.impl;

import com.applet.annotation.SystemServerLog;
import com.applet.mapper.UserInfoMapper;
import com.applet.mapper.WxUserInfoMapper;
import com.applet.model.UserInfo;
import com.applet.model.WxUserInfo;
import com.applet.service.AddRegisterUserService;
import com.applet.utils.common.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddRegisterUserServiceImpl implements AddRegisterUserService{

    private static final Logger LOGGER= LoggerFactory.getLogger(AddRegisterUserServiceImpl.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private WxUserInfoMapper wxUserInfoMapper;


    @Override
    @SystemServerLog(funcionExplain = "添加新用户注册")
    public UserInfo addRegisterUser(UserInfo userInfo,WxUserInfo wxUserInfo) {
        userInfoMapper.insertSelective(userInfo);
        LOGGER.debug("记录单车用户信息 {}", JSON.toJSONString(userInfo));
        wxUserInfo.setUserId(userInfo.getId());
        wxUserInfoMapper.insertSelective(wxUserInfo);
        LOGGER.debug("记录微信用户信息 {}", JSON.toJSONString(wxUserInfo));

        UserInfo info=new UserInfo();
        info.setId(userInfo.getId());
        info.setAccountStatus(userInfo.getAccountStatus());
       return  info;
    }
}
