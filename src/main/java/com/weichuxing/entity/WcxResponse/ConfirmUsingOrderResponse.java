package com.weichuxing.entity.WcxResponse;

public class ConfirmUsingOrderResponse extends BaseWcxResponse{

    private Integer order_status;

    private Integer indeed_way;

    private Integer indeed_time;

    private long indeed_fee;

    private Integer farecard_typeid;

    private String farecard_no;

    private Integer used_count;

    private String begin_time;

    private String end_time;

    public Integer getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Integer order_status) {
        this.order_status = order_status;
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
