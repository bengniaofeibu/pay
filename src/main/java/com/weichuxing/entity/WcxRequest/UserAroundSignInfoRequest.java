package com.weichuxing.entity.WcxRequest;

public class UserAroundSignInfoRequest extends BaseWcxRequest {


    /**
     * 微出行用户平台id
     **/
    private String openid;

    /**
     * 用户地址经度
     **/
    private Double usr_gps_lng;

    /**
     * 用户地址纬度
     **/
    private Double usr_gps_lat;

    /**
     * 搜索类型
     **/
    private Integer scope;

    /**
     * 标记类型 0 全部 1 单车 2 停车桩/停车点 3 电子围栏
     **/
    private Integer tag_type;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Double getUsr_gps_lng() {
        return usr_gps_lng;
    }

    public void setUsr_gps_lng(Double usr_gps_lng) {
        this.usr_gps_lng = usr_gps_lng;
    }

    public Double getUsr_gps_lat() {
        return usr_gps_lat;
    }

    public void setUsr_gps_lat(Double usr_gps_lat) {
        this.usr_gps_lat = usr_gps_lat;
    }

    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }

    public Integer getTag_type() {
        return tag_type;
    }

    public void setTag_type(Integer tag_type) {
        this.tag_type = tag_type;
    }
}
