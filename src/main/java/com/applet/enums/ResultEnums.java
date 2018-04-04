package com.applet.enums;

public enum ResultEnums {

    SERVER_ERROR(-1,"系统内部错误"),

    RETURN_SUCCESS(200,"SUCCESS"),

    NOT_FOUND_SESSION(404, "错误SESSION"),

    PARAM_IS_NULL(1001,"参数为空"),

    USER_DATA_VALIDATE_FAIL(1002,"用户数据验证失败"),

    INVALID_USER(20001,"无效用户"),

    USER_NON_RECHARGE(20002,"用户未充值"),

    SCAVENING_UNLOCK_ORDERNOTFINISH_ERROR(20003,"订单未结束"),

    SCAVENING_UNLOCK_FAILSMSOPENLOCK(20004,"短信开锁失败"),

    SCAVENING_UNLOCK_FAILGPRSOPENLOCK(20005,"GPRS开锁失败"),

    SCAVENING_UNLOCK_LOWBATTERYLEVEL(20006,"此车正在充电"),

    SCAVENING_UNLOCK_BICYCLENONOTFINISH(20007,"车辆不存在"),

    SCAVENING_UNLOCK_ERRORBARCODE(20008,"非法二维码"),

    USER_ALREADY_EXIST(1003,"用户已经存在"),

    WX_PLAY_FAIL(1004,"微信支付失败"),

    SCAVENING_UNLOCK_ERRORTRANSRECORD(20008,"订单错误");

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


