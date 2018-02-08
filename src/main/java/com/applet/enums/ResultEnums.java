package com.applet.enums;

public enum ResultEnums {

    SERVER_ERROR(500,"系统内部错误"),

    NOT_FOUND_SESSION(404, "错误SESSION"),

    PARAM_IS_NULL(0001,"参数为空"),

    SCAVENING_UNLOCK_BICYCLENONOTFINISH(2001,"此单车车辆编号不存在"),

    SCAVENING_UNLOCK_LOWBATTERYLEVEL(2002,"此单车正在充电"),

    INVALID_USER(2003,"无效的用户"),

    USER_NON_RECHARGE(2004,"请充值"),

    SCAVENING_UNLOCK_ORDERNOTFINISH_ERROR(2005,"有骑行订单未结束，无法开锁"),

    SCAVENING_UNLOCK_FAILGPRSOPENLOCK(2006,"GPRS开锁失败"),

    SCAVENING_UNLOCK_FAILSMSOPENLOCK(2007,"SMS开锁失败"),

    SCAVENING_UNLOCK_ERRORBARCODE(2008,"非法二维码");

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


