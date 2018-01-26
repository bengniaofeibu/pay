package com.weichuxing.service.impl;

import com.weichuxing.annotation.SystemServerLog;
import com.weichuxing.entity.WcxRequest.UserInfoRequest;
import com.weichuxing.model.WcxUserRegisterInfoRequest;
import com.weichuxing.entity.WcxResponse.UserInfoResponse;
import com.weichuxing.model.UserInfo;
import com.weichuxing.service.UserInfoService;
import com.weichuxing.utils.common.EncrypUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


@Service
public class UserInfoServiceImpl extends BaseServer implements UserInfoService {


    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    /**
     * x
     * 查询用户是否注册 是否缴纳押金
     *
     * @param userInfoRequest
     * @return
     */
    @Override
    @SystemServerLog(funcionExplain = "查询用户信息")
    public UserInfoResponse queryUserRegisterInfo(UserInfoRequest userInfoRequest) {
        UserInfoResponse userInfoResponse=null;
        try {
            String decryptKey = getDecryptKey(userInfoRequest);
            String userMobile = EncrypUtil.decrypt(userInfoRequest.getUser_mobile(), decryptKey);

            //根据手机号查询用户信息
            UserInfo userInfo = userInfoMapper.selectByUserPhone(userMobile);
            userInfoResponse = new UserInfoResponse();

            //用户未注册
            if (userInfo == null) {
                return userInfoResponse;
            }

            //用户已经注册和交纳押金
            if (userInfo.getAccountStatus().equals(1) || userInfo.getAccountStatus().equals(3)) {
                userInfoResponse.setRegist_flag(1);
                userInfoResponse.setDeposit_flag(3);
                userInfoResponse.setDeposit_fee(userInfo.getDeposit().longValue());
                return userInfoResponse;
            }

            //用户已经注册但是没有交纳押金
            if (userInfo.getAccountStatus().equals(0) || userInfo.getAccountStatus().equals(2)) {
                userInfoResponse.setRegist_flag(1);
                userInfoResponse.setDeposit_flag(5);
                return userInfoResponse;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfoResponse;
    }

    /**
     * 操作微出行用户注册信息
     *
     * @param wcxUserRegisterInfo
     */
    @Override
    @SystemServerLog(funcionExplain = "操作微出行用户注册信息")
    @Transactional(rollbackFor = Exception.class)
    public void notifyWcxUserRegisterInfo(WcxUserRegisterInfoRequest wcxUserRegisterInfo) {

        try {

            Long count = wcxUserRegisterInfoMapper.selectWcxUserCount(Long.valueOf(wcxUserRegisterInfo.getOpenid()));

            String decryptKey = getDecryptKey(wcxUserRegisterInfo);
//            String userName = EncrypUtil.decrypt(wcxUserRegisterInfo.getUserName(), decryptKey);
//            String userMobile = EncrypUtil.decrypt(wcxUserRegisterInfo.getUserMobile(), decryptKey);

            String userMobile = wcxUserRegisterInfo.getUserMobile();
            String userName=wcxUserRegisterInfo.getUserName();

            if (count.longValue()==0) {
                LOGGER.info("记录微出行注册用户信息");
                UserInfo info= userInfoMapper.selectByUserPhone(wcxUserRegisterInfo.getUserMobile());
                if (info==null){
                    //如果还没在车商平台注册过 现在在车商平台记录一条用户信息，在把刚刚插入的userId关联到微出行用户注册表中
                    UserInfo userInfo = new UserInfo();
                    userInfo.setAccountStatus(wcxUserRegisterInfo.getRegistFlag());
                    userInfo.setRealName(userName);
                    userInfo.setPhone(userMobile);
                    userInfo.setIdCardnum(wcxUserRegisterInfo.getUseridHash());
                    userInfo.setDeposit(new BigDecimal(wcxUserRegisterInfo.getDepositFee()));
                    userInfo.setUserSource(1);
                    userInfoMapper.insertUserInfo(userInfo);
                    wcxUserRegisterInfo.setUserId(userInfo.getId());
                    wcxUserRegisterInfoMapper.insertWcxUserInfo(wcxUserRegisterInfo);
                }else {
                    //已在车商注册过，只要在微出行关联表中记录车商userId
                    wcxUserRegisterInfo.setUserId(info.getId());
                    wcxUserRegisterInfoMapper.insertWcxUserInfo(wcxUserRegisterInfo);
                }
            } else {
                LOGGER.info("更新微出行注册用户信息");
                wcxUserRegisterInfoMapper.updateUserInfoById(wcxUserRegisterInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
