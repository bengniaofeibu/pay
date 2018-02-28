package com.applet.service.impl;

import com.applet.annotation.SystemServerLog;
import com.applet.entity.UserInfo.UserInfoResponse;
import com.applet.mapper.UserInfoMapper;
import com.applet.mapper.UserReportMapper;
import com.applet.mapper.WxUserInfoMapper;
import com.applet.model.UserInfo;
import com.applet.model.UserReport;
import com.applet.model.WxUserInfo;
import com.applet.service.UserInfoService;
import com.applet.utils.AppletResult;
import com.applet.utils.common.JSONUtil;
import com.applet.utils.common.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoServiceImpl.class);


    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private WxUserInfoMapper wxUserInfoMapper;

    @Autowired
    private UserReportMapper userReportMapper;


    @Override
    @SystemServerLog(funcionExplain = "添加新用户注册")
    @Transactional(rollbackFor = Exception.class)
    public UserInfoResponse addRegisterUser(UserInfo userInfo, WxUserInfo wxUserInfo) {
        if (userInfo.getUserSource() != 0) {
            userInfoMapper.insertSelective(userInfo);
            LOGGER.debug("记录单车用户信息 {}", JSONUtil.toJSONString(userInfo));
        }

        wxUserInfo.setUserId(userInfo.getId());
        wxUserInfoMapper.insertSelective(wxUserInfo);
        LOGGER.debug("记录微信用户信息 {}", JSONUtil.toJSONString(wxUserInfo));

        UserReport userReport=new UserReport(UuidUtil.getUuid(),0.0,0.0,0.0,userInfo.getId());
        userReportMapper.insertUserReportInfo(userReport);
        LOGGER.debug("记录用户report信息 {}",JSONUtil.toJSONString(userReport));

        UserInfoResponse info = new UserInfoResponse();
        info.setAdminId(userInfo.getId());
        info.setStatus(userInfo.getAccountStatus());
        return info;
    }

    /**
     * 获取用户信息
     *
     * @param id
     * @return
     */
    @Override
    @SystemServerLog(funcionExplain = "获取用户信息")
    public UserInfoResponse getUserInfo(String id) {
        UserInfo info = userInfoMapper.selectByPrimaryKey(id);
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse.setStatus(info.getAccountStatus());
        Integer borrowBicycle = info.getmBorrowBicycle();
        userInfoResponse.setBorrowBicycle(borrowBicycle);
        if (borrowBicycle.intValue() == 1) {
            long borrowBicycleDate = (new Date().getTime() - info.getmBorrowBicycleDate().getTime()) / (60 * 1000);
            userInfoResponse.setRidingTime(borrowBicycleDate);
        }
        return userInfoResponse;
    }
}
