package com.applet.model;

import java.util.Date;

public class ChinaPayOrderInfo {
    private Long id;

    private String orderNumber;

    private String orderStatus;

    private String splitType;

    private Short splitMethod;

    private String merSplitMsg;

    private String acqSeqId;

    private String acqDate;

    private String channelSeqId;

    private String channelDate;

    private String channelTime;

    private String bankInstNo;

    private String completeDate;

    private String completeTime;

    private Date addTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getSplitType() {
        return splitType;
    }

    public void setSplitType(String splitType) {
        this.splitType = splitType == null ? null : splitType.trim();
    }

    public Short getSplitMethod() {
        return splitMethod;
    }

    public void setSplitMethod(Short splitMethod) {
        this.splitMethod = splitMethod;
    }

    public String getMerSplitMsg() {
        return merSplitMsg;
    }

    public void setMerSplitMsg(String merSplitMsg) {
        this.merSplitMsg = merSplitMsg == null ? null : merSplitMsg.trim();
    }

    public String getAcqSeqId() {
        return acqSeqId;
    }

    public void setAcqSeqId(String acqSeqId) {
        this.acqSeqId = acqSeqId == null ? null : acqSeqId.trim();
    }

    public String getAcqDate() {
        return acqDate;
    }

    public void setAcqDate(String acqDate) {
        this.acqDate = acqDate == null ? null : acqDate.trim();
    }

    public String getChannelSeqId() {
        return channelSeqId;
    }

    public void setChannelSeqId(String channelSeqId) {
        this.channelSeqId = channelSeqId == null ? null : channelSeqId.trim();
    }

    public String getChannelDate() {
        return channelDate;
    }

    public void setChannelDate(String channelDate) {
        this.channelDate = channelDate == null ? null : channelDate.trim();
    }

    public String getChannelTime() {
        return channelTime;
    }

    public void setChannelTime(String channelTime) {
        this.channelTime = channelTime == null ? null : channelTime.trim();
    }

    public String getBankInstNo() {
        return bankInstNo;
    }

    public void setBankInstNo(String bankInstNo) {
        this.bankInstNo = bankInstNo == null ? null : bankInstNo.trim();
    }

    public String getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate == null ? null : completeDate.trim();
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime == null ? null : completeTime.trim();
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