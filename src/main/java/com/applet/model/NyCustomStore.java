package com.applet.model;

import com.applet.Base.BaseModel;

import java.util.Date;

public class NyCustomStore extends BaseModel {
    private String id;

    private String storeName;

    private String customId;

    private String contact;

    private String storeAddr;

    private String storeTel;

    private Long storeProvinceid;

    private Long storeCityid;

    private Long storeRegionid;

    private Long storeStreetid;

    private String longitude;

    private String latitude;

    private String serviceTel;

    private String businessBeginTime;

    private String businessEndTime;

    private String businessWeekday;

    private String storePic1;

    private String storePic2;

    private String storeRecommend;

    private Date addTime;

    private Boolean delFlag;

    private Boolean openFlag;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    /**  商户类型  **/
    private int coustomType;

    /**  是否需要放大  **/
    private int isEnlarge;

    /** 距离 **/
    private int distance;

    /** 到达时间（分钟） **/
    private long time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId == null ? null : customId.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getStoreAddr() {
        return storeAddr;
    }

    public void setStoreAddr(String storeAddr) {
        this.storeAddr = storeAddr == null ? null : storeAddr.trim();
    }

    public String getStoreTel() {
        return storeTel;
    }

    public void setStoreTel(String storeTel) {
        this.storeTel = storeTel == null ? null : storeTel.trim();
    }

    public Long getStoreProvinceid() {
        return storeProvinceid;
    }

    public void setStoreProvinceid(Long storeProvinceid) {
        this.storeProvinceid = storeProvinceid;
    }

    public Long getStoreCityid() {
        return storeCityid;
    }

    public void setStoreCityid(Long storeCityid) {
        this.storeCityid = storeCityid;
    }

    public Long getStoreRegionid() {
        return storeRegionid;
    }

    public void setStoreRegionid(Long storeRegionid) {
        this.storeRegionid = storeRegionid;
    }

    public Long getStoreStreetid() {
        return storeStreetid;
    }

    public void setStoreStreetid(Long storeStreetid) {
        this.storeStreetid = storeStreetid;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getServiceTel() {
        return serviceTel;
    }

    public void setServiceTel(String serviceTel) {
        this.serviceTel = serviceTel == null ? null : serviceTel.trim();
    }

    public String getBusinessBeginTime() {
        return businessBeginTime;
    }

    public void setBusinessBeginTime(String businessBeginTime) {
        this.businessBeginTime = businessBeginTime == null ? null : businessBeginTime.trim();
    }

    public String getBusinessEndTime() {
        return businessEndTime;
    }

    public void setBusinessEndTime(String businessEndTime) {
        this.businessEndTime = businessEndTime == null ? null : businessEndTime.trim();
    }

    public String getBusinessWeekday() {
        return businessWeekday;
    }

    public void setBusinessWeekday(String businessWeekday) {
        this.businessWeekday = businessWeekday == null ? null : businessWeekday.trim();
    }

    public String getStorePic1() {
        return storePic1;
    }

    public void setStorePic1(String storePic1) {
        this.storePic1 = storePic1 == null ? null : storePic1.trim();
    }

    public String getStorePic2() {
        return storePic2;
    }

    public void setStorePic2(String storePic2) {
        this.storePic2 = storePic2 == null ? null : storePic2.trim();
    }

    public String getStoreRecommend() {
        return storeRecommend;
    }

    public void setStoreRecommend(String storeRecommend) {
        this.storeRecommend = storeRecommend == null ? null : storeRecommend.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Boolean getOpenFlag() {
        return openFlag;
    }

    public void setOpenFlag(Boolean openFlag) {
        this.openFlag = openFlag;
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

    public int getCoustomType() {
        return coustomType;
    }

    public void setCoustomType(int coustomType) {
        this.coustomType = coustomType;
    }

    public int getIsEnlarge() {
        return isEnlarge;
    }

    public void setIsEnlarge(int isEnlarge) {
        this.isEnlarge = isEnlarge;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}