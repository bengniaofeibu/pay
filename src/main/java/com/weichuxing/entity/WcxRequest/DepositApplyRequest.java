package com.weichuxing.entity.WcxRequest;

public class DepositApplyRequest extends BaseWcxRequest{

    /** 微出行平台押金订单号 **/
    private String transaction_id;

    /** 微出行平台用户ID **/
    private String userid;

    /** 车商退押金订单号 **/
    private String out_refund_no;

    /**  押金金额 （单位分）**/
    private Long total_fee;

    /**  退款金额 （单位分）**/
    private Long refund_fee;

    /**  用户身份证号 **/
    private String userid_hash;

    /** 用户手机号 **/
    private String mobile_md5;

    /** 用户ip **/
    private String client_ip;


    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public void setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
    }

    public Long getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(Long total_fee) {
        this.total_fee = total_fee;
    }

    public Long getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee(Long refund_fee) {
        this.refund_fee = refund_fee;
    }

    public String getUserid_hash() {
        return userid_hash;
    }

    public void setUserid_hash(String userid_hash) {
        this.userid_hash = userid_hash;
    }

    public String getMobile_md5() {
        return mobile_md5;
    }

    public void setMobile_md5(String mobile_md5) {
        this.mobile_md5 = mobile_md5;
    }

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }
}
