package com.weichuxing.controller;

import com.alibaba.fastjson.JSON;
import com.weichuxing.utils.common.PostRequestUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sms")
@ConfigurationProperties(prefix = "sms", ignoreUnknownFields = true)
public class SMSController {

    private String prefix;

    private static final Integer TYPE = 1;

    private String url;


    private String checkUrl;

    @GetMapping("/cat")
    public ResponseEntity<String> get(@RequestParam("phone") String phone) {

        try {
            Map<String, Object> m = new HashMap<String, Object>();
            m.put("phone", phone);
            m.put("markId", prefix);
            m.put("smsType", TYPE);

            String s = PostRequestUtils.httpPostWithJSON(url, JSON.toJSONString(m));
            return ResponseEntity.status(HttpStatus.OK).body(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/fish")
    public ResponseEntity<String> check(@RequestParam("phone") String phone, @RequestParam("captchaNum") String captchaNum) {
        try {
            Map<String, Object> m = new HashMap<String, Object>();
            m.put("phone", phone);
            m.put("markId", prefix);
            m.put("captchaNum", captchaNum);
            String s = PostRequestUtils.httpPostWithJSON(checkUrl, JSON.toJSONString(m));
            return ResponseEntity.status(HttpStatus.OK).body(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCheckUrl() {
        return checkUrl;
    }

    public void setCheckUrl(String checkUrl) {
        this.checkUrl = checkUrl;
    }
}
