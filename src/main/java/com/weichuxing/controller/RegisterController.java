package com.weichuxing.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.weichuxing.entity.BackResult;
import com.weichuxing.utils.common.RedisUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.symmetric.AES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;

@RestController
@RequestMapping("re")
public class RegisterController {

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/phone")
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

}
