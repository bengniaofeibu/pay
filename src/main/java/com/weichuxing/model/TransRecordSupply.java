package com.weichuxing.model;

import java.math.BigDecimal;
import java.util.Date;

public class TransRecordSupply {
    private String transId;

    private BigDecimal discountMoney;

    private Integer fenceStatus;

    private String orderFrom;

    private Date updateTime;

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId == null ? null : transId.trim();
    }

    public BigDecimal getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(BigDecimal discountMoney) {
        this.discountMoney = discountMoney;
    }

    public Integer getFenceStatus() {
        return fenceStatus;
    }

    public void setFenceStatus(Integer fenceStatus) {
        this.fenceStatus = fenceStatus;
    }

    public String getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom == null ? null : orderFrom.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}