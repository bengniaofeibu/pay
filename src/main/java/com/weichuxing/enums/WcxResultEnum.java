package com.weichuxing.enums;

public enum WcxResultEnum {
    SIGN_FAIL(1001, "无效的签名"),
    INVALID_USER(1002,"无效的用户"),
    POINT_OR_SCOPE_NOT_LEGAL(1003,"经纬度或查找范围不合法"),
    YINYAN_SERVER_ERROR(1016,"鹰眼轨迹服务异常"),
    YINYAN_SEARCH_ERROR(1016,"鹰眼查询异常");


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
