package com.applet.enums;

import com.applet.utils.common.JSONUtil;

import java.util.HashMap;
import java.util.Map;

public enum  WxCallBackResultEnums {

    CALL_BACK_NOTIFY_SUCCESS("SUCCESS",""),

    CALL_BACK_NOTIFY_SIGIN_FAIL("FAIL","签名失败"),

    CALL_BACK_NOTIFY_FAIL("FAIL","通信失败"),

    CALL_BACK_BUSINESS_FAIL("FAIL","业务失败");

    String return_code;

    String return_msg;

    WxCallBackResultEnums(String return_code, String return_msg) {
        this.return_code = return_code;
        this.return_msg = return_msg;
    }

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    /**
     * 生成微信回调接口Map
     * @param wxCallBackResultEnums
     * @return
     */
    public static Map<String,String>  returnCallResult(WxCallBackResultEnums wxCallBackResultEnums){
        Map<String,String> backMap=new HashMap<>();
        backMap.put("return_code",wxCallBackResultEnums.getReturn_code());
        backMap.put("return_msg",wxCallBackResultEnums.getReturn_msg());
        return backMap;
    }
}
