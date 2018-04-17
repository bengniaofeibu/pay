package com.applet.model;

import com.applet.Base.BaseModel;

public class BaseOrderInfo extends BaseModel {

    private static final long serialVersionUID = 5895699582957353403L;

    private String orderNumber;

    private String userPayNumber;

    private String tradeNo;

    public BaseOrderInfo(String orderNumber, String userPayNumber) {
        this.orderNumber = orderNumber;
        this.userPayNumber = userPayNumber;
    }

    public BaseOrderInfo(String orderNumber, String userPayNumber, String tradeNo) {
        this.orderNumber = orderNumber;
        this.userPayNumber = userPayNumber;
        this.tradeNo = tradeNo;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }


    public String getUserPayNumber() {
        return userPayNumber;
    }

    public void setUserPayNumber(String userPayNumber) {
        this.userPayNumber = userPayNumber;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
}
