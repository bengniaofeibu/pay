package com.applet.utils.HttpClient;

import java.util.Map;

public class HttpApiUtils {

    private static String recEncoding = "UTF-8";

    public static String getRecEncoding() {
        return recEncoding;
    }

    public static void setRecEncoding(String recEncoding) {
        HttpApiUtils.recEncoding = recEncoding;
    }

    public static String getBikeInfos(Map params){
        String url ="http://139.196.194.172:8084/LockApi/lock?action=GETBIKEINFOS";//测试环境
        return HttpRequestProxy.doPost(url, params , getRecEncoding());
    }

    public static String openLockByGprs(Map params){
        String url = "http://10.0.180.37/MidComPro/lock?action=OPENLOCK";
        return HttpRequestProxy.doPost(url, params , getRecEncoding());
    }

    /**
     * 微信支付请求
     * @param params
     * @return
     */
    public static String sendRequest(String params){
         return HttpsUtil.httpMethodPost("https://api.mch.weixin.qq.com/pay/unifiedorder",params);
    }

    public static String openLockBySms(Map params){
        String url = "http://106.14.155.161/SMSComPro/Sms?action=SENDSMSUNLOCK";
        return HttpRequestProxy.doPost(url, params , getRecEncoding());
    }
}
