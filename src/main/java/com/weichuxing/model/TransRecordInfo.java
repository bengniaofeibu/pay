package com.weichuxing.model;

import java.math.BigDecimal;
import java.util.Date;

public class TransRecordInfo {
    private String id;

    private Integer borrowBatteryNum;

    private Integer borrowBicycleNum;

    private Date borrowDateTime;

    private Integer orderIntegral;

    private Long orderNum;

    private Integer recessionBatteryNum;

    private Integer recessionBicycleNum;

    private Date recessionDateTime;

    private Integer state;

    private Integer transFlag;

    private BigDecimal transMoney;

    private Date uploadDate;

    private String userId;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String endPosition;

    private BigDecimal kilometers;

    private String startPosition;

    private Integer bicycleType;

    private String simNo;

    private Integer useBlueTooth;

    private Long calorie;

    private String duration;

    private Integer userType;

    private Date lastUsedTime;

    private Integer delFlag;

    private Integer cityNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getBorrowBatteryNum() {
        return borrowBatteryNum;
    }

    public void setBorrowBatteryNum(Integer borrowBatteryNum) {
        this.borrowBatteryNum = borrowBatteryNum;
    }

    public Integer getBorrowBicycleNum() {
        return borrowBicycleNum;
    }

    public void setBorrowBicycleNum(Integer borrowBicycleNum) {
        this.borrowBicycleNum = borrowBicycleNum;
    }

    public Date getBorrowDateTime() {
        return borrowDateTime;
    }

    public void setBorrowDateTime(Date borrowDateTime) {
        this.borrowDateTime = borrowDateTime;
    }

    public Integer getOrderIntegral() {
        return orderIntegral;
    }

    public void setOrderIntegral(Integer orderIntegral) {
        this.orderIntegral = orderIntegral;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getRecessionBatteryNum() {
        return recessionBatteryNum;
    }

    public void setRecessionBatteryNum(Integer recessionBatteryNum) {
        this.recessionBatteryNum = recessionBatteryNum;
    }

    public Integer getRecessionBicycleNum() {
        return recessionBicycleNum;
    }

    public void setRecessionBicycleNum(Integer recessionBicycleNum) {
        this.recessionBicycleNum = recessionBicycleNum;
    }

    public Date getRecessionDateTime() {
        return recessionDateTime;
    }

    public void setRecessionDateTime(Date recessionDateTime) {
        this.recessionDateTime = recessionDateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getTransFlag() {
        return transFlag;
    }

    public void setTransFlag(Integer transFlag) {
        this.transFlag = transFlag;
    }

    public BigDecimal getTransMoney() {
        return transMoney;
    }

    public void setTransMoney(BigDecimal transMoney) {
        this.transMoney = transMoney;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(String endPosition) {
        this.endPosition = endPosition == null ? null : endPosition.trim();
    }

    public BigDecimal getKilometers() {
        return kilometers;
    }

    public void setKilometers(BigDecimal kilometers) {
        this.kilometers = kilometers;
    }

    public String getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(String startPosition) {
        this.startPosition = startPosition == null ? null : startPosition.trim();
    }

    public Integer getBicycleType() {
        return bicycleType;
    }

    public void setBicycleType(Integer bicycleType) {
        this.bicycleType = bicycleType;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo == null ? null : simNo.trim();
    }

    public Integer getUseBlueTooth() {
        return useBlueTooth;
    }

    public void setUseBlueTooth(Integer useBlueTooth) {
        this.useBlueTooth = useBlueTooth;
    }

    public Long getCalorie() {
        return calorie;
    }

    public void setCalorie(Long calorie) {
        this.calorie = calorie;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Date getLastUsedTime() {
        return lastUsedTime;
    }

    public void setLastUsedTime(Date lastUsedTime) {
        this.lastUsedTime = lastUsedTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getCityNo() {
        return cityNo;
    }

    public void setCityNo(Integer cityNo) {
        this.cityNo = cityNo;
    }
}