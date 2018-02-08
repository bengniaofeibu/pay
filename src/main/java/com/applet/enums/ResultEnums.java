package com.applet.enums;

public enum ResultEnums {

    SERVER_ERROR(500,"系统内部错误"),

    NOT_FOUND_SESSION(404, "错误SESSION"),

    PARAM_IS_NULL(10001,"参数为空"),

    USER_DATA_VALIDATE_FAIL(10002,"用户数据验证失败"),

    USER_ALREADY_EXIST(10003,"用户已经存在");

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


