package com.applet.enums;

public enum  WxCallBackResultEnums {

    CALL_BACK_FEE_NOT_EQUAL_FAIL("FAIL","支付金额与用户订单金额不一致"),

    CALL_BACK_NOTIFY_SUCCESS("SUCCESS",""),

    CALL_BACK_NOTIFY_SIGIN_FAIL("FAIL","签名失败"),

    CALL_BACK_NOTIFY_FAIL("FAIL","通知失败");

    String return_code;

    String return_msg;

    WxCallBackResultEnums(String return_code, String return_msg) {
        this.return_code = return_code;
        this.return_msg = return_msg;
    }

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }
}
