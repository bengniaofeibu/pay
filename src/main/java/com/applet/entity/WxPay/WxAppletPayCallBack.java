package com.applet.entity.WxPay;

import com.applet.entity.BaseEntity.BaseRequestEntity;

public class WxAppletPayCallBack extends BaseRequestEntity{

    /**
     * 微信分配的小程序ID
     **/
    private String appid;

    /**
     * 微信支付分配的商户号
     **/
    private String mch_id;

    /**
     * 随机字符串
     **/
    private String nonce_str;

    /**
     * 业务结果	 SUCCESS/FAIL
     **/
    private String result_code;

    /**
     * 用户在商户appid下的唯一标识
     **/
    private String openid;

    /**
     * 交易类型 JSAPI、NATIVE、APP
     **/
    private String trade_type;

    /**
     * 银行类型
     **/
    private String bank_type;

    /**
     * 订单总金额，单位为分
     **/
    private Integer total_fee;

    /**
     * 现金支付金额订单现金支付金额
     **/
    private Integer cash_fee;

    /**
     * 微信支付订单号
     **/
    private String transaction_id;

    /**
     * 商户系统内部订单号
     **/
    private String out_trade_no;

    /**
     * 支付完成时间
     **/
    private String time_end;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getBank_type() {
        return bank_type;
    }

    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    public Integer getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
    }

    public Integer getCash_fee() {
        return cash_fee;
    }

    public void setCash_fee(Integer cash_fee) {
        this.cash_fee = cash_fee;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }
}
