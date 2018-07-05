package com.applet.model;

import java.math.BigDecimal;
import java.util.Date;

public class UserTransLog {
    private Long id;

    private String userId;

    private String userOrderNo;

    private String transAccountNo;

    private Short transWay;

    private Date addTime;

    private Date updateTime;

    public UserTransLog() {
    }

    public UserTransLog(String userId, String userOrderNo, String transAccountNo, Short transWay) {
        this.userId = userId;
        this.userOrderNo = userOrderNo;
        this.transAccountNo = transAccountNo;
        this.transWay = transWay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserOrderNo() {
        return userOrderNo;
    }

    public void setUserOrderNo(String userOrderNo) {
        this.userOrderNo = userOrderNo == null ? null : userOrderNo.trim();
    }

    public String getTransAccountNo() {
        return transAccountNo;
    }

    public void setTransAccountNo(String transAccountNo) {
        this.transAccountNo = transAccountNo == null ? null : transAccountNo.trim();
    }

    public Short getTransWay() {
        return transWay;
    }

    public void setTransWay(Short transWay) {
        this.transWay = transWay;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}