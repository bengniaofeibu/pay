package com.weichuxing.entity.WcxResponse;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.weichuxing.utils.common.JSON;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WcxResult {

     /** 返回码 **/
     Integer ret;

     /** msg **/
     String msg;

     /** 业务返回具体信息 **/
     Object data;

    public Integer getRet() {
        return ret;
    }

    public void setRet(Integer ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 转换成实体对象
     * @param tClass
     * @return
     */
    public static <T> T parseToObject(Object data,Class<T> tClass){
        if (data!=null){
            return  JSON.parseObject(JSON.toJSONString(data),tClass);
        }
       return null;
    }
}
