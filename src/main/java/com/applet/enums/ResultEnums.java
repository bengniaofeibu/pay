package com.applet.enums;

public enum ResultEnums {

    SERVER_ERROR(-1,"系统内部错误"),

    CHINA_SERVER_ERROR(1000,"银联服务错误"),

    RETURN_SUCCESS(200,"SUCCESS"),

    NOT_FOUNT_ORDERNUM_FAIL(1003,"无此订单"),

    WX_PLAY_FAIL(1004,"微信支付失败"),

    PAY_AMOUNT_EXCEPTION_FAIL(1005,"支付金额异常"),

    CHINA_SIGNING_QUERY_FAIL(1006,"签约查询失败"),

    CHINA_TRADING_ELEMENTS_QUERY_FAIL(1007,"交易要素查询失败"),

    CHINA_SIGNING_SMS_FAIL(1008,"签约短信发送失败"),

    CHINA_SIGNING_FAIL(1009,"签约失败"),

    CHINA_UNSIGNING_FAIL(1100,"签约失败"),

    CHINA_PAY_SMS_FAIL(1101,"支付短信发送失败"),

    CHINA_PAY_FAIL(1102,"银联支付失败"),

    USER_OPEN_ID_NOT_FOUND_FAIL(1103,"请先微信授权"),

    ORDER_STATUS_ALREADY_COMPLETE(1104,"该笔订单已经退款或转账，请查询微信转账记录"),

    WX_TRANSFER_SUCCESS(1105,"微信转账成功"),

    ORDER_STATUS_UPDATE_FAIL(1106,"订单状态更新失败"),

    WX_TRANSFER_FAIL(1107,"微信转账失败"),

    USER_ACCOUNT_STATUS_FAIL(1108,"非缴纳押金状态"),

    USER_NOT_FOUND_FAIL(1109,"用户不存在"),

    USER_CREDIT_INSUFFICIENT_FAIL(1110,"信用分不足80分");

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


