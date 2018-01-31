package com.weichuxing.entity.WcxRequest;

public class ScavengingUnlockRequest extends BaseWcxRequest{

    /*微出行平台用户ID*/
    private String openId;

    /* 订单ID，如：20170810000312325545220000。
    微出行平台在扫码开蓝牙锁，机械锁的情况下，
    为保 证用车安全，防止开锁完没创建订单会在调用此接口 之前创建订单*/
    private String order_id;

    /*二维码原串,经过BASE64加密,由车商去解析二维码， 判断是否执行开锁*/
    private String qrcode_content;

    /*发送请求的时间，格式"yyyyMMddHHmmss" 20170724030750*/
    private String timestamp;

    /*当前位置纬度，GPS测量数值(WGS-84 坐标系)，不 含地图纠偏数据*/
    private double gps_lat;

    /*当前位置经度，GPS测量数值(WGS-84 坐标系)，不 含地图纠偏数据*/
    private double gps_lng;

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

    public String getQrcode_content() {
        return qrcode_content;
    }

    public void setQrcode_content(String qrcode_content) {
        this.qrcode_content = qrcode_content;
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
}
