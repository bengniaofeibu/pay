package com.weichuxing.entity.WcxResponse;

public class ReportBikeFinishResponse extends BaseWcxResponse{

    /* 单车锁状态 1: locked 2: unlocked */
    private Integer bike_status;

    /*实际路程，单位米 */
    private Integer indeed_way;

    /*实际时长，单位秒 */
    private Integer indeed_time;

    /*实际扣费，单位分 */
    private long indeed_fee;

    /*骑行扣费，单位分 */
    private long charging_fee;

    /*车费卡类型编号，如果用户此次骑行使用了车费卡则 返回此字段 */
    private Integer farecard_typeid;

    /*车费卡卡号，如果用户此次骑行使用了车费卡则返回 此字段*/
    private String farecard_no;

    /*结合车费卡的限次类型，此字段有不同的含义：
    不限次---> 无意义，默认为0 按天限次---> 当天已经使用的次数 按优惠卡有效期限次---> 有效期使用的总次数*/
    private Integer used_count;

    /*车费卡开始时间，格式"yyyyMMddHHmmss" ，如果用户此次骑行使用了车费卡则返回此字段*/
    private String begin_time;

    /*车费卡结束时间，格式"yyyyMMddHHmmss，如果用户此次骑行使用了车费卡则返回此字段"*/
    private String end_time;

    public Integer getBike_status() {
        return bike_status;
    }

    public void setBike_status(Integer bike_status) {
        this.bike_status = bike_status;
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
