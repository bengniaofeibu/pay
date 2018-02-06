package com.applet.enums;

public enum ResultEnums {

    SERVER_ERROR(500,"系统内部错误"),

    NOT_FOUND_SESSION(404, "错误SESSION"),

    PARAM_IS_NULL(0001,"参数为空");

    private Integer code;

    private String msg;

    ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}


