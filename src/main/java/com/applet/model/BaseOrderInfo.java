package com.applet.model;

import com.applet.Base.BaseModel;

import java.math.BigDecimal;

public class BaseOrderInfo extends BaseModel {

    private static final long serialVersionUID = 5895699582957353403L;

    private String orderNumber;

    private BigDecimal totalAmount;

    private String userPayNumber;

    private String tradeNo;

    private Short payWay;

    public BaseOrderInfo() {
    }



    public BaseOrderInfo(BigDecimal totalAmount,Short payWay,String orderNumber,String userPayNumber, String tradeNo) {
        this.totalAmount=totalAmount;
        this.payWay=payWay;
        this.orderNumber=orderNumber;
        this.userPayNumber = userPayNumber;
        this.tradeNo = tradeNo;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
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

    public Short getPayWay() {
        return payWay;
    }

    public void setPayWay(Short payWay) {
        this.payWay = payWay;
    }
}
