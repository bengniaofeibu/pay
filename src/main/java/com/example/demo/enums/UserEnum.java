package com.example.demo.enums;

public enum UserEnum {
    UNKONW_ERROR(500, "未知错误"),
    SUCCESS(200, "成功"),
    NOT_FOUND(404, "未找到"),
    TOO_SHORT(100, "太短了"),
    TOO_SHORT2(101, "字数少于20"),
    DUPLICATE_USER_NAME(102, "用户名已存在"),
    ;

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

    UserEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
