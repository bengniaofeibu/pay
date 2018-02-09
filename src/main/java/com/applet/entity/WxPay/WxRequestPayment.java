package com.applet.entity.WxPay;

public class WxRequestPayment {

    private String timeStamp;

    private  String nonceStr;

    private String  reqPackage;

    private String signType;

    private String paySign;

    private String appid;

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getReqPackage() {
        return reqPackage;
    }

    public void setReqPackage(String reqPackage) {
        this.reqPackage = reqPackage;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getPaySign() {
        return paySign;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
