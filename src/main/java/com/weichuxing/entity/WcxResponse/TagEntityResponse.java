package com.weichuxing.entity.WcxResponse;

import com.weichuxing.entity.WcxRequest.BaseWcxRequest;

public class TagEntityResponse extends BaseWcxRequest{

    /** 标记目录 **/
    private String tag_id;

    /** 标记ID   **/
    private String tag_type;

    /** 标记类型 0：全部 1 单车 2 停车桩 3 电子围栏 **/
    private String tag_gps_lat;

    /** 标记纬度 **/
    private String tag_gps_lng;

    /** 标记经度  **/
    private String tag_uptime;

    /** 标记距中心点距离  **/
    private Double tag_distance;

    /** 标记方向 **/
    private Integer tag_direction;

    /** 车型编号 **/
    private String model_id;

    /**  车型类型 **/
    private Integer model_type;


    public String getTag_id() {
        return tag_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    public String getTag_type() {
        return tag_type;
    }

    public void setTag_type(String tag_type) {
        this.tag_type = tag_type;
    }

    public String getTag_gps_lat() {
        return tag_gps_lat;
    }

    public void setTag_gps_lat(String tag_gps_lat) {
        this.tag_gps_lat = tag_gps_lat;
    }

    public String getTag_gps_lng() {
        return tag_gps_lng;
    }

    public void setTag_gps_lng(String tag_gps_lng) {
        this.tag_gps_lng = tag_gps_lng;
    }

    public String getTag_uptime() {
        return tag_uptime;
    }

    public void setTag_uptime(String tag_uptime) {
        this.tag_uptime = tag_uptime;
    }

    public Double getTag_distance() {
        return tag_distance;
    }

    public void setTag_distance(Double tag_distance) {
        this.tag_distance = tag_distance;
    }

    public Integer getTag_direction() {
        return tag_direction;
    }

    public void setTag_direction(Integer tag_direction) {
        this.tag_direction = tag_direction;
    }

    public String getModel_id() {
        return model_id;
    }

    public void setModel_id(String model_id) {
        this.model_id = model_id;
    }

    public Integer getModel_type() {
        return model_type;
    }

    public void setModel_type(Integer model_type) {
        this.model_type = model_type;
    }
}
