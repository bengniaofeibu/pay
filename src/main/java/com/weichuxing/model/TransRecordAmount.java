package com.weichuxing.model;

import com.weichuxing.entity.WcxRequest.BaseWcxRequest;

import java.util.Date;

public class TransRecordAmount extends BaseWcxRequest{
    private Long id;

    private String bikeId;

    private String modelId;

    private Integer modelType;

    private String orderId;

    private Integer payResult;

    private Long indeedFee;

    private Long chargingFee;

    private String userId;

    private Date addTime;

    private Date updateTime;

    private String openid;

    private Integer resourceId;

    public TransRecordAmount() {
    }

    public TransRecordAmount(String bikeId, String modelId, Integer modelType, String orderId, Integer payResult, Long indeedFee, Long chargingFee, String userId, Date addTime, Date updateTime, String openid, Integer resourceId) {
        this.bikeId = bikeId;
        this.modelId = modelId;
        this.modelType = modelType;
        this.orderId = orderId;
        this.payResult = payResult;
        this.indeedFee = indeedFee;
        this.chargingFee = chargingFee;
        this.userId = userId;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.openid = openid;
        this.resourceId = resourceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBikeId() {
        return bikeId;
    }

    public void setBikeId(String bikeId) {
        this.bikeId = bikeId == null ? null : bikeId.trim();
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    public Integer getModelType() {
        return modelType;
    }

    public void setModelType(Integer modelType) {
        this.modelType = modelType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getPayResult() {
        return payResult;
    }

    public void setPayResult(Integer payResult) {
        this.payResult = payResult;
    }

    public Long getIndeedFee() {
        return indeedFee;
    }

    public void setIndeedFee(Long indeedFee) {
        this.indeedFee = indeedFee;
    }

    public Long getChargingFee() {
        return chargingFee;
    }

    public void setChargingFee(Long chargingFee) {
        this.chargingFee = chargingFee;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }
}