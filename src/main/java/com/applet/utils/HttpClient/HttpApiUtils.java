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

    public static String getBikeInfo(Map params){
        String url ="http://10.0.180.67/LockApi/lock?action=GETBIKEINFO";//正式环境
//		String url="http://10.31.20.69:8084/LockApi/lock?action=GETBIKEINFO"; //开发环境
//		String url="http://10.25.22.59:8084/LockApi/lock?action=GETBIKEINFO";//测试环境
        return HttpRequestProxy.doPost(url, params , getRecEncoding());
    }

    public static String openLock(Map params){
        String url = "http://10.0.180.37/MidComPro/lock?action=OPENLOCK";
        return HttpRequestProxy.doPost(url, params , getRecEncoding());
    }
}
