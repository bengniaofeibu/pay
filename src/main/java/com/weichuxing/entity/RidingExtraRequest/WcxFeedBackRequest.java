package com.weichuxing.entity.RidingExtraRequest;

import com.weichuxing.entity.WcxRequest.BaseWcxRequest;

public class WcxFeedBackRequest extends BaseWcxRequest {


    /**
     * 微出行用户平台id
     **/
    private String openid;

    /**
     * 订单 ID
     **/
    private String order_id;

    /**
     * 单车 ID
     **/
    private String bike_id;

    /**
     * 车型编号
     **/
    private String model_id;

    /**
     * 车锁类型
     1: 蓝牙锁
     2: 智能锁(GSM, GPRS, NB-IOT)
     3: 智能锁 + 蓝牙锁
     4: 机械锁
     5: 智能锁 + 机械锁
     6: 蓝牙锁 + 机械锁
     **/
    private Integer model_type;

    /**
     * 发送请求的时间，格式"yyyyMMddHHmmss"
     20170724030750
     */
    private String timestamp;

    /**
     * 故障部件，用户选择报修结束时，此字段必填，多选，
     多个选项之间用 | 分隔，如 3|4|6
     30 / 56
     1.车把歪斜
     2.刹车失灵
     3.轮胎有问题
     4.脚踏板故障
     5.座椅故障
     6.链条故障
     7.车锁故障
     8.其他问题
     */
    private String faulty_parts;

    /**
     * 故障描述，用户选择报修结束时，此字段必填
     除零部件损坏之外的其他故障，用户描述之后上报给
     单车平台
     */
    private String faulty_desc;

    /**
     * 车辆纬度，GPS 测量数值(WGS-84 坐标系)，不含地
     图纠偏数据
     */
    private Double gps_lat;

    /**
     * 车辆经度，GPS 测量数值(WGS-84 坐标系)，不含地
     图纠偏数据
     */
    private Double gps_lng;

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

    public String getFaulty_parts() {
        return faulty_parts;
    }

    public void setFaulty_parts(String faulty_parts) {
        this.faulty_parts = faulty_parts;
    }

    public String getFaulty_desc() {
        return faulty_desc;
    }

    public void setFaulty_desc(String faulty_desc) {
        this.faulty_desc = faulty_desc;
    }

    public Double getGps_lat() {
        return gps_lat;
    }

    public void setGps_lat(Double gps_lat) {
        this.gps_lat = gps_lat;
    }

    public Double getGps_lng() {
        return gps_lng;
    }

    public void setGps_lng(Double gps_lng) {
        this.gps_lng = gps_lng;
    }
}
