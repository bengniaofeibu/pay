package com.weichuxing.enums;

public enum WcxResultEnum {
    SIGN_FAIL(1001, "无效的签名");

    private Integer code;
    private String msg;

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

    WcxResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
