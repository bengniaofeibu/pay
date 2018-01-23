package com.weichuxing.entity.WcxResponse;

public class FarecardInfoResponse{

    /** 车费卡类型编号  **/
    private Integer farecard_typeid;

    /** 车费卡卡号 **/
    private String farecard_no;

    /**  车费卡是否有效标识 ，1：有效 2 ：失效  **/
    private Integer farecard_valid;

    /**  结合车费卡的限次类型 ，此字段有不同的含义 ：不限次---> 无意义 ，默认为0   按天限次---> 当天已经使用的次数 **/
    private Integer used_count;

    /** 车费卡开始时间，格式"yyyyMMddHHmmss **/
    private String begin_time;

    /** 车费卡结束时间，格式"yyyyMMddHHmmss **/
    private String end_time;

    public Integer getFarecard_typeid() {
        return farecard_typeid;
    }

    public void setFarecard_typeid(Integer farecard_typeid) {
        this.farecard_typeid = farecard_typeid;
    }

    public String getFarecard_no() {
        return farecard_no;
    }

    public void setFarecard_no(String farecard_no) {
        this.farecard_no = farecard_no;
    }

    public Integer getFarecard_valid() {
        return farecard_valid;
    }

    public void setFarecard_valid(Integer farecard_valid) {
        this.farecard_valid = farecard_valid;
    }

    public Integer getUsed_count() {
        return used_count;
    }

    public void setUsed_count(Integer used_count) {
        this.used_count = used_count;
    }

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}
