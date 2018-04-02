package com.applet.entity;

public class StorePoint {

    /** 经度 **/
    private String lng;

    /** 纬度 **/
    private String lat;

    public StorePoint() {
    }

    public StorePoint(String lng, String lat) {
        this.lng = lng;
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
