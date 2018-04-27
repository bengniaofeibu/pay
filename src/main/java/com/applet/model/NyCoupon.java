package com.applet.model;

import java.util.Date;

public class NyCoupon {
    private String id;

    private String couponTypeId;

    private String couponCode;

    private String couponDesc;

    private Date beginTime;

    private Date endTime;

    private Integer couponStatus;

    private Date createDate;

    private String createBy;

    private Date updateDate;

    private String updateBy;

    private Integer delFlag;

    private Integer isExpired;

    private String couponSourceId;

    private String eventId;

    private Boolean isLock;

    private Long validPeriod;

    private Boolean agingType;

    private NyCouponType nyCouponType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCouponTypeId() {
        return couponTypeId;
    }

    public void setCouponTypeId(String couponTypeId) {
        this.couponTypeId = couponTypeId == null ? null : couponTypeId.trim();
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode == null ? null : couponCode.trim();
    }

    public String getCouponDesc() {
        return couponDesc;
    }

    public void setCouponDesc(String couponDesc) {
        this.couponDesc = couponDesc == null ? null : couponDesc.trim();
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(Integer couponStatus) {
        this.couponStatus = couponStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(Integer isExpired) {
        this.isExpired = isExpired;
    }

    public String getCouponSourceId() {
        return couponSourceId;
    }

    public void setCouponSourceId(String couponSourceId) {
        this.couponSourceId = couponSourceId == null ? null : couponSourceId.trim();
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId == null ? null : eventId.trim();
    }

    public Boolean getIsLock() {
        return isLock;
    }

    public void setIsLock(Boolean isLock) {
        this.isLock = isLock;
    }

    public Long getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(Long validPeriod) {
        this.validPeriod = validPeriod;
    }

    public Boolean getAgingType() {
        return agingType;
    }

    public void setAgingType(Boolean agingType) {
        this.agingType = agingType;
    }

    public Boolean getLock() {
        return isLock;
    }

    public void setLock(Boolean lock) {
        isLock = lock;
    }

    public NyCouponType getNyCouponType() {
        return nyCouponType;
    }

    public void setNyCouponType(NyCouponType nyCouponType) {
        this.nyCouponType = nyCouponType;
    }
}