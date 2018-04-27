package com.applet.model;

import java.util.Date;

public class NyCouponType {
    private String id;

    private String couponType;

    private String couponTypeName;

    private String couponAssignType;

    private String storeId;

    private Long parValue;

    private Long discount;

    private Long conditionValue;

    private Boolean isRepeatable;

    private Boolean isMixable;

    private Long validPeriod;

    private String couponUrl;

    private String imageUrl;

    private Date updateDate;

    private String updateBy;

    private Date createDate;

    private String createBy;

    private Boolean delFlag;

    private Boolean isBind;

    private Boolean isUse;

    private Long countTotal;

    private Long countLeft;

    private Boolean isAuto;

    private Date beginTime;

    private Date endTime;

    private Boolean agingType;

    private String tonePh;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType == null ? null : couponType.trim();
    }

    public String getCouponTypeName() {
        return couponTypeName;
    }

    public void setCouponTypeName(String couponTypeName) {
        this.couponTypeName = couponTypeName == null ? null : couponTypeName.trim();
    }

    public String getCouponAssignType() {
        return couponAssignType;
    }

    public void setCouponAssignType(String couponAssignType) {
        this.couponAssignType = couponAssignType == null ? null : couponAssignType.trim();
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    public Long getParValue() {
        return parValue;
    }

    public void setParValue(Long parValue) {
        this.parValue = parValue;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Long getConditionValue() {
        return conditionValue;
    }

    public void setConditionValue(Long conditionValue) {
        this.conditionValue = conditionValue;
    }

    public Boolean getIsRepeatable() {
        return isRepeatable;
    }

    public void setIsRepeatable(Boolean isRepeatable) {
        this.isRepeatable = isRepeatable;
    }

    public Boolean getIsMixable() {
        return isMixable;
    }

    public void setIsMixable(Boolean isMixable) {
        this.isMixable = isMixable;
    }

    public Long getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(Long validPeriod) {
        this.validPeriod = validPeriod;
    }

    public String getCouponUrl() {
        return couponUrl;
    }

    public void setCouponUrl(String couponUrl) {
        this.couponUrl = couponUrl == null ? null : couponUrl.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
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

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Boolean getIsBind() {
        return isBind;
    }

    public void setIsBind(Boolean isBind) {
        this.isBind = isBind;
    }

    public Boolean getIsUse() {
        return isUse;
    }

    public void setIsUse(Boolean isUse) {
        this.isUse = isUse;
    }

    public Long getCountTotal() {
        return countTotal;
    }

    public void setCountTotal(Long countTotal) {
        this.countTotal = countTotal;
    }

    public Long getCountLeft() {
        return countLeft;
    }

    public void setCountLeft(Long countLeft) {
        this.countLeft = countLeft;
    }

    public Boolean getIsAuto() {
        return isAuto;
    }

    public void setIsAuto(Boolean isAuto) {
        this.isAuto = isAuto;
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

    public Boolean getAgingType() {
        return agingType;
    }

    public void setAgingType(Boolean agingType) {
        this.agingType = agingType;
    }

    public String getTonePh() {
        return tonePh;
    }

    public void setTonePh(String tonePh) {
        this.tonePh = tonePh == null ? null : tonePh.trim();
    }
}