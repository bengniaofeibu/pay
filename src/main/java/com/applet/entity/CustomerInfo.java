package com.applet.entity;

import com.applet.Base.BaseEntity;

public class CustomerInfo extends BaseEntity {
    private static final long serialVersionUID = 4885441308232145678L;

    /** 地址id **/
    private String addressId;

    /** 客户唯一标识 **/
    private String userId;

    /** 客户名称 **/
    private String customerName;

    /** 客户手机号 **/
    private String customerPhone;

    /** 客户所在省份 **/
    private String  customerProvince;

    /** 客户所在城市 **/
    private String customerCity;

    /** 客户所在区 **/
    private String customerArea;

    /** 客户详细地址 **/
    private String customerDetailedAddress;

    public CustomerInfo() {
    }


    public CustomerInfo(String customerProvince, String customerCity, String customerArea, String customerDetailedAddress) {
        this.customerProvince = customerProvince;
        this.customerCity = customerCity;
        this.customerArea = customerArea;
        this.customerDetailedAddress = customerDetailedAddress;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerProvince() {
        return customerProvince;
    }

    public void setCustomerProvince(String customerProvince) {
        this.customerProvince = customerProvince;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerArea() {
        return customerArea;
    }

    public void setCustomerArea(String customerArea) {
        this.customerArea = customerArea;
    }

    public String getCustomerDetailedAddress() {
        return customerDetailedAddress;
    }

    public void setCustomerDetailedAddress(String customerDetailedAddress) {
        this.customerDetailedAddress = customerDetailedAddress;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "addressId='" + addressId + '\'' +
                ", userId='" + userId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerProvince='" + customerProvince + '\'' +
                ", customerCity='" + customerCity + '\'' +
                ", customerArea='" + customerArea + '\'' +
                ", customerDetailedAddress='" + customerDetailedAddress + '\'' +
                '}';
    }
}
