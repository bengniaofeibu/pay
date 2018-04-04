package com.applet.model;

import com.applet.Base.BaseModel;

import java.util.Date;

public class CustomerAddressInfo extends BaseModel {

    private static final long serialVersionUID = 5895699582957353403L;

    private Long id;

    private String userId;

    private String customerName;

    private String customerPhone;

    private String customerPlaceProvice;

    private String customerPlaceCity;

    private String customerPlaceArea;

    private String customerDetailedAddress;

    private Short delFlag;

    private Short customerAddressType;

    private Date addTime;

    private Date updateTime;

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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone == null ? null : customerPhone.trim();
    }

    public String getCustomerPlaceProvice() {
        return customerPlaceProvice;
    }

    public void setCustomerPlaceProvice(String customerPlaceProvice) {
        this.customerPlaceProvice = customerPlaceProvice == null ? null : customerPlaceProvice.trim();
    }

    public String getCustomerPlaceCity() {
        return customerPlaceCity;
    }

    public void setCustomerPlaceCity(String customerPlaceCity) {
        this.customerPlaceCity = customerPlaceCity == null ? null : customerPlaceCity.trim();
    }

    public String getCustomerPlaceArea() {
        return customerPlaceArea;
    }

    public void setCustomerPlaceArea(String customerPlaceArea) {
        this.customerPlaceArea = customerPlaceArea == null ? null : customerPlaceArea.trim();
    }

    public String getCustomerDetailedAddress() {
        return customerDetailedAddress;
    }

    public void setCustomerDetailedAddress(String customerDetailedAddress) {
        this.customerDetailedAddress = customerDetailedAddress == null ? null : customerDetailedAddress.trim();
    }

    public Short getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Short delFlag) {
        this.delFlag = delFlag;
    }

    public Short getCustomerAddressType() {
        return customerAddressType;
    }

    public void setCustomerAddressType(Short customerAddressType) {
        this.customerAddressType = customerAddressType;
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

    @Override
    public String toString() {
        return "CustomerAddressInfo{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerPlaceProvice='" + customerPlaceProvice + '\'' +
                ", customerPlaceCity='" + customerPlaceCity + '\'' +
                ", customerPlaceArea='" + customerPlaceArea + '\'' +
                ", customerDetailedAddress='" + customerDetailedAddress + '\'' +
                ", customerAddressType=" + customerAddressType +
                ", delFlag=" + delFlag +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                '}';
    }
}