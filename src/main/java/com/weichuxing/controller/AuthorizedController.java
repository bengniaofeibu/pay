package com.weichuxing.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.weichuxing.entity.Cat;
import com.weichuxing.entity.WxApplet;
import com.weichuxing.utils.HttpClient.HttpsUtil;
import com.weichuxing.utils.common.Md5Util;
import com.weichuxing.utils.common.RedisUtil;
import com.weichuxing.utils.common.UuidUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Authorized")
public class AuthorizedController {

    @Autowired
    private RedisUtil redisUtil;


    @Autowired
    private WxApplet wxApplet;

    @GetMapping("/init")
    public ResponseEntity<String> login(@RequestParam("js_code")String code){

        try {
            Cat cat = new Cat();
            StringBuffer sb = new StringBuffer();
            sb.append("https://api.weixin.qq.com/sns/jscode2session?");
            sb.append("appid=");
            sb.append(wxApplet.getAppId());
            sb.append("&secret=");
            sb.append(wxApplet.getAppSecret());
            sb.append("&js_code=");
            sb.append(code);
            sb.append("&grant_type=authorization_code");
            String s = HttpsUtil.httpMethodGet(sb.toString());
            JSONObject jo = JSON.parseObject(s);

            String openId = jo.getString("openid");
            String sessionKey = jo.getString("session_key");


            if(StringUtils.isBlank(openId)||StringUtils.isBlank(sessionKey)){

                return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }

            String unionId = jo.getString("unionid");

            String uuid = UuidUtil.getUuid();
            String rdSession = Md5Util.MD5(uuid + openId);

            cat.setOpenId(openId);
            cat.setSessionKey(sessionKey);

            redisUtil.setObjAndExpire(rdSession,cat,wxApplet.getSessionTime());
            return ResponseEntity.status(HttpStatus.OK).body(rdSession);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/check")
    public ResponseEntity<Boolean>  checkSession(@RequestParam("session")String session){

        try {
            Object valueObj = redisUtil.getValueObj(session);
            if(valueObj == null){

                return ResponseEntity.status(HttpStatus.OK).body(false);
            }else{

                return ResponseEntity.status(HttpStatus.OK).body(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}


