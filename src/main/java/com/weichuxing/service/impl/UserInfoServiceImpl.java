package com.weichuxing.service.impl;

import com.weichuxing.annotation.SystemServerLog;
import com.weichuxing.entity.WcxRequest.UserInfoRequest;
import com.weichuxing.entity.WcxResponse.UserInfoResponse;
import com.weichuxing.mapper.UserInfoMapper;
import com.weichuxing.model.UserInfo;
import com.weichuxing.service.UserInfoService;
import com.weichuxing.utils.common.EncrypUtil;
import com.weichuxing.utils.common.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

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
     * 生成解密的key
     * key=取中间16位MD5(用财付通商户号+nonce_str)
     *
     * @param userInfoRequest
     * @return
     */
    private String getDecryptKey(UserInfoRequest userInfoRequest) {
        StringBuffer stringBuffer = new StringBuffer(userInfoRequest.getSp_id() + userInfoRequest.getNonce_str());
        return Md5Util.MD5(stringBuffer.toString()).substring(9, 25);
    }
}
