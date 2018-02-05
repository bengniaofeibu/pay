package com.weichuxing.enums;

public enum Result {

    NOT_FOUND_SESSION(404, "错误SESSION");

    private Integer code;

    private String msg;

    Result(Integer code, String msg) {
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


