package com.weichuxing.entity.LockRequest;

public class CloseLockCallbackRequest extends BaseLockRequest{

    private String openid;

    private String order_id;

    private String bike_id;

    private String model_id;

    private Integer model_type;

    private String timestamp;

    private double gps_lat;

    private double gps_lng;

    private Integer indeed_way;

    private Integer indeed_time;

    private long indeed_fee;

    private long charging_fee;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getBike_id() {
        return bike_id;
    }

    public void setBike_id(String bike_id) {
        this.bike_id = bike_id;
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public double getGps_lat() {
        return gps_lat;
    }

    public void setGps_lat(double gps_lat) {
        this.gps_lat = gps_lat;
    }

    public double getGps_lng() {
        return gps_lng;
    }

    public void setGps_lng(double gps_lng) {
        this.gps_lng = gps_lng;
    }

    public Integer getIndeed_way() {
        return indeed_way;
    }

    public void setIndeed_way(Integer indeed_way) {
        this.indeed_way = indeed_way;
    }

    public Integer getIndeed_time() {
        return indeed_time;
    }

    public void setIndeed_time(Integer indeed_time) {
        this.indeed_time = indeed_time;
    }

    public long getIndeed_fee() {
        return indeed_fee;
    }

    public void setIndeed_fee(long indeed_fee) {
        this.indeed_fee = indeed_fee;
    }

    public long getCharging_fee() {
        return charging_fee;
    }

    public void setCharging_fee(long charging_fee) {
        this.charging_fee = charging_fee;
    }
}
