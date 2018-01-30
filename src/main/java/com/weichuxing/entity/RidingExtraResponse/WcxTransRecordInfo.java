package com.weichuxing.entity.RidingExtraResponse;

import com.weichuxing.entity.WcxResponse.BaseWcxResponse;

public class WcxTransRecordInfo extends BaseWcxResponse {

    /** 微出行平台用户ID **/
    private String openid;

    private String bike_id;

    private String model_id;

    private Integer model_type;

    private String order_id;

    private Integer order_status;

    private String time_start;

    private String time_end;

    private Double start_gps_lat;

    private Double start_gps_lng;

    private Double end_gps_lat;

    private Double end_gps_lng;

    private Integer indeed_way;

    private Integer indeed_time;

    private Long indeed_fee;

    private Long charging_fee;


    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
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

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Integer getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Integer order_status) {
        this.order_status = order_status;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public Double getStart_gps_lat() {
        return start_gps_lat;
    }

    public void setStart_gps_lat(Double start_gps_lat) {
        this.start_gps_lat = start_gps_lat;
    }

    public Double getStart_gps_lng() {
        return start_gps_lng;
    }

    public void setStart_gps_lng(Double start_gps_lng) {
        this.start_gps_lng = start_gps_lng;
    }

    public Double getEnd_gps_lat() {
        return end_gps_lat;
    }

    public void setEnd_gps_lat(Double end_gps_lat) {
        this.end_gps_lat = end_gps_lat;
    }

    public Double getEnd_gps_lng() {
        return end_gps_lng;
    }

    public void setEnd_gps_lng(Double end_gps_lng) {
        this.end_gps_lng = end_gps_lng;
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

    public Long getIndeed_fee() {
        return indeed_fee;
    }

    public void setIndeed_fee(Long indeed_fee) {
        this.indeed_fee = indeed_fee;
    }

    public Long getCharging_fee() {
        return charging_fee;
    }

    public void setCharging_fee(Long charging_fee) {
        this.charging_fee = charging_fee;
    }
}
