package com.applet.utils;

import com.applet.enums.ResultEnums;
import org.springframework.stereotype.Component;

@Component
public class ResultUtil {
    public static AppletResult success(ResultEnums resultEnums,Object...object){

        AppletResult result = new AppletResult();
        result.setCode(resultEnums.getCode());
        result.setMsg(resultEnums.getMsg());
        result.setData(new ResultBuild(object));
        return result;
    }

    public static AppletResult success(Object object){
        AppletResult result = new AppletResult();
        result.setCode(ResultEnums.RETURN_SUCCESS.getCode());
        result.setMsg(ResultEnums.RETURN_SUCCESS.getMsg());
        result.setData(new ResultBuild(object));
        return result;
    }

    public static AppletResult success(){
        AppletResult result = new AppletResult();
        result.setCode(ResultEnums.RETURN_SUCCESS.getCode());
        result.setMsg(ResultEnums.RETURN_SUCCESS.getMsg());
        result.setData(new ResultBuild(null));
        return result;
    }



    public static AppletResult error(ResultEnums resultEnums,String...msg){
        AppletResult result = new AppletResult();
        result.setCode(resultEnums.getCode());
        if (msg.length>0){
            StringBuffer sb=new StringBuffer(resultEnums.getMsg());
            result.setMsg(sb.append(",").append(msg[0]).toString());
        }else {
            result.setMsg(resultEnums.getMsg());
        }
        result.setData(new ResultBuild());
        return result;
    }

    static class ResultBuild{

        private Object returnData;

        public ResultBuild() {
        }

        public ResultBuild(Object returnData) {
            this.returnData = returnData;
        }

        public Object getReturnData() {
            return returnData;
        }

        public void setReturnData(Object returnData) {
            this.returnData = returnData;
        }
    }
}
