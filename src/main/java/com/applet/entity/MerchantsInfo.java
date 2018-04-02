package com.applet.entity;

import com.applet.Base.BaseEntity;

import java.util.List;

public class MerchantsInfo extends BaseEntity {
    private static final long serialVersionUID = -7855511492882330762L;

    /**
     * 商家图片url
     **/
    public String imageUrl;

    /**
     * 商家类型名称
     **/
    private String customName;

    /**
     * 商家类型
     **/
    private Integer customType;


    /** 店内图片 **/
    private List<String> storeImagesUrl;

    /** 查看数 **/
    private Long seeNum;

    /** 详情H5Url **/
    private String storeH5Url;

    /** 商店标题 **/
    private String storeTitle;

    public MerchantsInfo() {
    }


    public MerchantsInfo(String imageUrl, String customName, Integer customType) {
        this.imageUrl = imageUrl;
        this.customName = customName;
        this.customType = customType;
    }


    public MerchantsInfo(List<String> storeImagesUrl, Long seeNum, String storeH5Url, String storeTitle) {
        this.storeImagesUrl = storeImagesUrl;
        this.seeNum = seeNum;
        this.storeH5Url = storeH5Url;
        this.storeTitle = storeTitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public Integer getCustomType() {
        return customType;
    }

    public void setCustomType(Integer customType) {
        this.customType = customType;
    }

    public List<String> getStoreImagesUrl() {
        return storeImagesUrl;
    }

    public void setStoreImagesUrl(List<String> storeImagesUrl) {
        this.storeImagesUrl = storeImagesUrl;
    }

    public Long getSeeNum() {
        return seeNum;
    }

    public void setSeeNum(Long seeNum) {
        this.seeNum = seeNum;
    }

    public String getStoreH5Url() {
        return storeH5Url;
    }

    public void setStoreH5Url(String storeH5Url) {
        this.storeH5Url = storeH5Url;
    }

    public String getStoreTitle() {
        return storeTitle;
    }

    public void setStoreTitle(String storeTitle) {
        this.storeTitle = storeTitle;
    }

    @Override
    public String toString() {
        return "MerchantsInfo{" +
                "imageUrl='" + imageUrl + '\'' +
                ", customName='" + customName + '\'' +
                ", customType=" + customType +
                ", storeImagesUrl=" + storeImagesUrl +
                ", seeNum=" + seeNum +
                ", storeH5Url='" + storeH5Url + '\'' +
                ", storeTitle='" + storeTitle + '\'' +
                '}';
    }
}
