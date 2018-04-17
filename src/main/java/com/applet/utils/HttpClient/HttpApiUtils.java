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


    /**
     * 微信支付请求
     * @param params
     * @return
     */
    public static String sendRequest(String reqUrl,String params){
         return HttpsUtil.httpMethodPost(reqUrl,params);
    }
}
