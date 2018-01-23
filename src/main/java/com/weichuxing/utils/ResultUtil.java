package com.weichuxing.utils;

import org.springframework.stereotype.Component;

@Component
public class ResultUtil {
    public static WcxResult success(Object object){

        WcxResult result = new WcxResult();
        result.setRet(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }


    public static WcxResult error(Integer code, String msg){
        WcxResult result = new WcxResult();
        result.setRet(code);
        result.setMsg(msg);
        return result;
    }
}
