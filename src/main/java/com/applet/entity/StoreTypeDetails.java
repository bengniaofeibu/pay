package com.applet.entity;

import com.applet.Base.BaseEntity;

public class StoreTypeDetails extends BaseEntity {

    private static final long serialVersionUID = 4885441308232145678L;

    /** 图片 **/
    private String imageUrl;

    /** 描述 **/
    private String title;

    /** 商家地址 **/
    private String address;

    /** 总浏览数 **/
    private Long browseNum;

    /** 用户路过数 **/
    private Long userPassByNum;

    public StoreTypeDetails() {
    }


    public StoreTypeDetails(String imageUrl, String title, String address, Long browseNum, Long userPassByNum) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.address = address;
        this.browseNum = browseNum;
        this.userPassByNum = userPassByNum;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getBrowseNum() {
        return browseNum;
    }

    public void setBrowseNum(Long browseNum) {
        this.browseNum = browseNum;
    }

    public Long getUserPassByNum() {
        return userPassByNum;
    }

    public void setUserPassByNum(Long userPassByNum) {
        this.userPassByNum = userPassByNum;
    }

    @Override
    public String toString() {
        return "StoreTypeDetails{" +
                "imageUrl='" + imageUrl + '\'' +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", browseNum=" + browseNum +
                ", userPassByNum=" + userPassByNum +
                '}';
    }
}
