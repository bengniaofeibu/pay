package com.weichuxing.model;

import java.util.Date;


public class FeedBackInfo {

    private String id;

    // 用户ID
    private String userId;

    // 类型（1：违停举报 2：故障报修 3：意见反馈 4：其他问题）
    private int type;

    // 子类型   违停举报(1:) 故障报修（20：） 意见反馈(40:)
    private String sonType;

    // 照片路径
    private String picurl;

    // 问题描述
    private String description;

    // 生成时间
    private Date addTime;

    private int bicycleNum;

    //联系方式
    private String phone;

    private String address;

    //反馈来源(1.赳赳单车 2.微出行)
    private Integer platform;

    //骑行id
    private String transId;

    //车辆纬度(WGS-84 坐标系)，不含地图纠偏数据
    private String bikeLat;

    //车辆经度(WGS-84 坐标系)，不含地图纠偏数据
    private String bikeLng;

    //微出行用户id
    private String openId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSonType() {
        return sonType;
    }

    public void setSonType(String sonType) {
        this.sonType = sonType;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public int getBicycleNum() {
        return bicycleNum;
    }

    public void setBicycleNum(int bicycleNum) {
        this.bicycleNum = bicycleNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        this.transId = transId;
    }

    public String getBikeLat() {
        return bikeLat;
    }

    public void setBikeLat(String bikeLat) {
        this.bikeLat = bikeLat;
    }

    public String getBikeLng() {
        return bikeLng;
    }

    public void setBikeLng(String bikeLng) {
        this.bikeLng = bikeLng;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
