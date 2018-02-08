package com.applet.model;

import java.util.Date;

public class FeedbackInfo {
    private String id;

    private Date addtime;

    private Integer bicycleNum;

    private String description;

    private String picurl;

    private String sonType;

    private Integer type;

    private String userId;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    private String phone;

    private Integer checkedType;

    private String address;

    private Integer isBikeFaulted;

    private Integer platform;

    private String transId;

    private String bikeLat;

    private String bikeLng;

    private String openId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Integer getBicycleNum() {
        return bicycleNum;
    }

    public void setBicycleNum(Integer bicycleNum) {
        this.bicycleNum = bicycleNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl == null ? null : picurl.trim();
    }

    public String getSonType() {
        return sonType;
    }

    public void setSonType(String sonType) {
        this.sonType = sonType == null ? null : sonType.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getCheckedType() {
        return checkedType;
    }

    public void setCheckedType(Integer checkedType) {
        this.checkedType = checkedType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getIsBikeFaulted() {
        return isBikeFaulted;
    }

    public void setIsBikeFaulted(Integer isBikeFaulted) {
        this.isBikeFaulted = isBikeFaulted;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId == null ? null : transId.trim();
    }

    public String getBikeLat() {
        return bikeLat;
    }

    public void setBikeLat(String bikeLat) {
        this.bikeLat = bikeLat == null ? null : bikeLat.trim();
    }

    public String getBikeLng() {
        return bikeLng;
    }

    public void setBikeLng(String bikeLng) {
        this.bikeLng = bikeLng == null ? null : bikeLng.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }
}