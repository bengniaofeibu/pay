package com.weichuxing.entity.WcxRequest;

public class ReportBikeFinishRequest extends BaseWcxRequest{

    /*微出行平台用户ID*/
    private String openid;

    /*订单ID*/
    private String order_id;

    /*单车ID*/
    private String bike_id;

    /*车型编号*/
    private String model_id;

    /*车锁类型
    * 1: 蓝牙锁
    * 2: 智能锁(GSM, GPRS, NB-IOT)
    * 3: 智能锁 + 蓝牙锁
    * 4: 机械锁
    * 5: 智能锁 + 机械锁
    * 6: 蓝牙锁 + 机械锁*/
    private Integer model_type;

    /*上报结束类型
    * 1: 报修结束
    * 2: 蓝牙锁关锁，无法通讯结束
    * 3: 机械锁和蓝牙锁关锁，正常结束； 注意，如果用户之前发过报修请求，再次发起正常关锁结束，实际计费以第一次报修为准*/
    private Integer report_type;

    /*发送请求的时间，格式"yyyyMMddHHmmss" 20170724030750*/
    private String timestamp;

    /*车辆纬度*/
    private double gps_lat;

    /*车辆经度*/
    private double gps_lng;

    /*故障部件，用户选择报修结束时，此字段必填，多选， 多个选项之间用 | 分隔，如3|4|6
    * 9.车把歪斜
    * 10.刹车失灵
    * 11.轮胎有问题
    * 12.脚踏板故障
    * 13.座椅故障
    * 14.链条故障
    * 15.车锁故障
    * 16.其他问题
    * */
    private String faulty_parts;

    /*
    * 故障描述，用户选择报修结束时，此字段必填 除零部件损坏之外的其他故障，用户描述之后上报给 单车平台*/
    private String faulty_desc;

    /*骑行路程，单位米 */
    private Integer ride_way;

    /*骑行时间，单位秒 */
    private Integer time_spend;

    /*骑行扣费，单位分*/
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

    public Integer getReport_type() {
        return report_type;
    }

    public void setReport_type(Integer report_type) {
        this.report_type = report_type;
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

    public Integer getRide_way() {
        return ride_way;
    }

    public void setRide_way(Integer ride_way) {
        this.ride_way = ride_way;
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
