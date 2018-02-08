package com.applet.controller.UserInfoController;

import com.applet.annotation.SystemControllerLog;
import com.applet.controller.BaseController;
import com.applet.entity.Cat;
import com.applet.entity.UserInfo.WxGeneralUserInfo;
import com.applet.entity.UserInfo.WxUserRegisterRequest;
import com.applet.entity.UserInfo.PhoneRegisterRequest;
import com.applet.entity.UserInfo.UserInfoResponse;
import com.applet.entity.UserInfo.WxDetailedUserInfo;
import com.applet.enums.ResultEnums;
import com.applet.model.UserInfo;
import com.applet.model.WxUserInfo;
import com.applet.service.UserInfoService;
import com.applet.utils.AppletResult;
import com.applet.utils.ResultUtil;
import com.applet.utils.common.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;

@RestController
@RequestMapping("/re")
public class UserController extends BaseController {


    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserInfoService userInfoService;

    @SystemControllerLog(funcionExplain = "进入微信注册登录控制层")
    @GetMapping("/wx_xcx_auth")
    public AppletResult register(WxUserRegisterRequest request, @RequestHeader("session") String session) {

        Cat authInfo = getAuthInfo(session);
        LOGGER.debug(" authInfo {}", JSONUtil.toJSONString(authInfo));


        //验证请求参数是否完整
        AppletResult appletResult = validateReqParam(request);
        if (appletResult != null) {
            return appletResult;
        }

        //验证用户是否已经注册
        AppletResult userRegistered = isUserRegistered(authInfo.getOpenId());
        if (userRegistered!=null){
            return userRegistered;
        }


        StringBuffer buffer = new StringBuffer(request.getRawData());
        String signature = Sha1Util.encode(buffer.append(authInfo.getSessionKey()).toString());
        if (!signature.equals(request.getSignature())) {
            LOGGER.debug("signature {} wxsignature {}", signature, request.getSignature());
            return ResultUtil.error(ResultEnums.USER_DATA_VALIDATE_FAIL);
        }

        try {

            WxDetailedUserInfo detailedUserInfo = JSONUtil.parseObject(request.getRawData(), WxDetailedUserInfo.class);

            WxGeneralUserInfo generalUserInfo = encryptedDataToObject(request.getGeneralEncryptedData(), authInfo.getSessionKey(), request.getIv(), WxGeneralUserInfo.class);

            UserInfoResponse info = baseAddRegisterUser(authInfo.getOpenId(), generalUserInfo.getPhoneNumber(), detailedUserInfo.getCountry(), detailedUserInfo.getGender(), detailedUserInfo.getNickName(),detailedUserInfo.getAvatarUrl());
            return ResultUtil.success(info);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    @SystemControllerLog(funcionExplain = "进入手机号注册登录控制层")
    @GetMapping("/wx_xcx_phone")
    public AppletResult phoneRegister(PhoneRegisterRequest request, @RequestHeader("session") String session) {
        System.out.println("进入手机号注册登录控制层");
        try {

            Cat authInfo = getAuthInfo(session);
            LOGGER.debug(" authInfo {}", JSONUtil.toJSONString(authInfo));

            //验证用户是否已经注册
            AppletResult userRegistered = isUserRegistered(authInfo.getOpenId());
            if (userRegistered!=null){
                return userRegistered;
            }

            UserInfoResponse info = baseAddRegisterUser(authInfo.getOpenId(), request.getPhone(), null, null, null,null);
            return ResultUtil.success(info);
        } catch (Exception e) {
            LOGGER.error(" ERROR {}", e.getMessage());
            return ResultUtil.error(ResultEnums.SERVER_ERROR);
        }
    }


    @SystemControllerLog(funcionExplain = "进入获取用户信息控制层")
    @GetMapping(value = "/wx_xcx_userinfo")
    public AppletResult getUserInfo(String id) {
        try {
            UserInfoResponse userInfo = userInfoService.getUserInfo(id);
            return ResultUtil.success(userInfo);
        } catch (Exception e) {
            LOGGER.error(" ERROR {}", e.getMessage());
            return ResultUtil.error(ResultEnums.SERVER_ERROR);
        }
    }

    /**
     * 添加新用户的公共方法
     *
     * @param openId
     * @param phone
     * @param country
     * @return
     */
    private UserInfoResponse baseAddRegisterUser(String openId, String phone, String country, Integer gender, String nickname, String picurl) {

        UserInfo userInfo = new UserInfo();
        userInfo.setId(UuidUtil.getUuid());
        userInfo.setUserSource(2);
        userInfo.setAccountStatus(0);
        userInfo.setPhone(phone);
        userInfo.setNationality(country == null ? "" : country);
        userInfo.setGuesterState(gender == null ? 0 : gender);
        userInfo.setNickname(nickname == null ? "" : nickname);
        userInfo.setPicurl(picurl == null ? "" : picurl);

        WxUserInfo wxUserInfo = new WxUserInfo();
        wxUserInfo.setOpenId(openId);
        wxUserInfo.setUserName(nickname == null ? "" : nickname);
        wxUserInfo.setUserMobile(phone);
        wxUserInfo.setRegistFlag(4);
        UserInfoResponse info = userInfoService.addRegisterUser(userInfo, wxUserInfo);
        return info;
    }
}
