package com.applet.enums;

public enum  ChinaPayTranTypeEnums {

    /** 签约查询 **/
    SIGINING_AND_QUERY("0504"),

    /** 交易要素  **/
    TRADING_ELEMENTS_QUERY("0505"),

    /** 签约短信 **/
    SIGINING_SMS("0608"),

    /** 签约 **/
    SIGINING("9904"),

    /** 解约 **/
    UNSIGINING("9905"),

    /** 支付短信 **/
    PAY_SMS("0606"),

    /** 支付 **/
    CHINA_PAY("0004");


    ChinaPayTranTypeEnums(String tranType) {
        this.tranType = tranType;
    }

    String tranType;

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }


}
