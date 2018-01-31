package com.weichuxing.entity.WcxRequest;

public class ConfirmUsingOrderRequest extends BaseWcxRequest{

    /*微出行平台用户ID*/
    private String openId;

    /*订单id*/
    private String order_id;

    /*单车id*/
    private String bike_id;

    /*车型编号*/
    private String model_id;

    /*车锁类型*/
    private Integer model_type;

    /*车辆纬度*/
    private double gps_lat;

    /*车辆经度*/
    private double gps_lng;

    /*骑行路程*/
    private Integer ride_path;

    /*骑行时间*/
    private Integer time_spend;

    /*骑行扣费*/
    private long charging_fee;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
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

    public Integer getRide_path() {
        return ride_path;
    }

    public void setRide_path(Integer ride_path) {
        this.ride_path = ride_path;
    }

    public Integer getTime_spend() {
        return time_spend;
    }

    public void setTime_spend(Integer time_spend) {
        this.time_spend = time_spend;
    }

    public long getCharging_fee() {
        return charging_fee;
    }

    public void setCharging_fee(long charging_fee) {
        this.charging_fee = charging_fee;
    }
}
