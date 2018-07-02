package com.applet.utils.HttpClient;

import com.alibaba.fastjson.JSONObject;
import com.applet.utils.common.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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


    /**
     * 银联支付请求
     * @param params
     * @return
     */
    public static <T> T sendRequestToChinaPay(String reqUrl,Map<String,Object> params,Class<T> tClass){
        String res= HttpRequestProxy.sendToOtherServer(reqUrl,params);
        String json=JSONUtil.toJSONString(JSONUtil.paserStrtoMap(res));
        return JSONUtil.parseObject(JSONUtil.toJSONString(JSONUtil.paserStrtoMap(res)),tClass);
    }

    /**
     * 银联支付请求
     * @param params
     * @return
     */
    public static Map sendRequestToChinaPay(String reqUrl,Map<String,Object> params){
        String res= HttpRequestProxy.sendToOtherServer(reqUrl,params);
        return JSONUtil.paserStrtoMap(res);
    }

    /**
     * 银联代付支付请求
     * @param params
     * @return
     */
    public static Map sendRequestToChinaSinPay(String reqUrl,Map<String,Object> params){
        String res= HttpRequestProxy.sendToOtherServer(reqUrl,params);
        return JSONUtil.paserStrtoMap(res);
    }


    /**
     * 请求公共方法
     * 方式 post
     * 格式 json
     * @param reqUrl
     * @param jsonObject
     * @return
     */
    public static <T>  T pSendResquestJson(String reqUrl, JSONObject jsonObject,Class<T> aclass){
        String s = HttpRequestProxy.doPost(reqUrl, jsonObject);
        return JSONUtil.parseObject(s,aclass);
    }
}
