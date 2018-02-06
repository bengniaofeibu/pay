package com.applet.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.applet.annotation.SystemControllerLog;
import com.applet.entity.BackResult;
import com.applet.entity.Cat;
import com.applet.entity.PhoneRegisterRequest;
import com.applet.enums.ResultEnums;
import com.applet.mapper.UserInfoMapper;
import com.applet.mapper.WxUserInfoMapper;
import com.applet.model.UserInfo;
import com.applet.model.WxUserInfo;
import com.applet.service.AddRegisterUserService;
import com.applet.utils.AppletResult;
import com.applet.utils.ResultUtil;
import com.applet.utils.common.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("re")
public class RegisterController extends  BaseController{


    private static final Logger LOGGER= LoggerFactory.getLogger(RegisterController.class);


    @Autowired
    private AddRegisterUserService addRegisterUserService;

    @PostMapping("/wxauth")
    public ResponseEntity<BackResult> register(@RequestBody String json){

        JSONObject jo = JSON.parseObject(json);

        String encryptedData = jo.getString("encryptedData");
        if(StringUtils.isBlank(encryptedData)){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        String vi = jo.getString("vi");
        if(StringUtils.isBlank(vi)){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        String session = jo.getString("session");
        if(StringUtils.isBlank(session)){

            return  ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        //AES aes = new AES();

        //从缓存中获取session_key
        Object wxSessionObj = redisUtil.getValueObj(session);
//        if(null == wxSessionObj){
//            return rtnParam(40008, null);
//        }
//        String wxSessionStr = (String)wxSessionObj;
//        String sessionKey = wxSessionStr.split("#")[0];
//
//        try {
//            AES aes = new AES();
//            byte[] resultByte = aes.decrypt(Base64.decodeBase64(encryptedData), Base64.decodeBase64(sessionKey), Base64.decodeBase64(iv));
//            if(null != resultByte && resultByte.length > 0){
//                String userInfo = new String(resultByte, "UTF-8");
//                return rtnParam(0, userInfo);
//            }
//        } catch (InvalidAlgorithmParameterException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return rtnParam(50021, null);

        return  null;
    }

    @SystemControllerLog(funcionExplain = "进入手机号注册登录控制层")
    @PostMapping("/phone")
    public AppletResult phoneRegister(@RequestBody PhoneRegisterRequest request){

        try {

            //验证参数是否为空
            AppletResult appletResult = validateReqParam(request);
            if (appletResult!=null){
                return appletResult;
            }

//            Cat authInfo = getAuthInfo(request.getSession());

            UserInfo userInfo=new UserInfo();
            userInfo.setUserSource(2);
            userInfo.setAccountStatus(0);
            userInfo.setPhone(request.getPhone());

            WxUserInfo wxUserInfo=new WxUserInfo();
            wxUserInfo.setOpenId("54615151151");
            wxUserInfo.setUserMobile(request.getPhone());
            wxUserInfo.setRegistFlag(4);
            UserInfo info = addRegisterUserService.addRegisterUser(userInfo, wxUserInfo);
            return ResultUtil.success(info);
        }catch (Exception e){
            LOGGER.error(" ERROR {}" ,e.getMessage());
            return ResultUtil.error(ResultEnums.SERVER_ERROR);
        }
    }
}
