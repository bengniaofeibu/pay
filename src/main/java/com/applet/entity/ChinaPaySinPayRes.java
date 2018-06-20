package com.applet.entity;

import com.applet.Base.BaseEntity;
import com.applet.utils.chinapayutils.PathUtil;

public class ChinaPaySinPayRes extends BaseEntity {

    private static final long serialVersionUID = 4885441308232145678L;

    /** 请求应答码 **/
    private String responseCode;

    /** 商户id **/
    private String merId;

    /** 交易发生的日期 **/
    private String merDate;

    /** 交易订单 **/
    private String merSeqId;

    /** ChinaPay接收到交易的日期 **/
    private String cpDate;

    /** ChinaPay系统内部流水 **/
    private String cpSeqId;

    /**金额 单位 分**/
    private String transAmt;

    /** 交易状态码 **/
    private String stat;

    /** 收款账号 银行卡号或者存折号 **/
    private String cardNo;

    /**签名值**/
    private String chkValue;


    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getMerId() {
        return merId;
    }

    public void setMerId(String merId) {
        this.merId = merId;
    }

    public String getMerDate() {
        return this.merDate;
    }

    public void setMerDate(String merDate) {
        this.merDate = merDate;
    }

    public String getMerSeqId() {
        return merSeqId;
    }

    public void setMerSeqId(String merSeqId) {
        this.merSeqId = merSeqId;
    }

    public String getCpDate() {
        return cpDate;
    }

    public void setCpDate(String cpDate) {
        this.cpDate = cpDate;
    }

    public String getCpSeqId() {
        return cpSeqId;
    }

    public void setCpSeqId(String cpSeqId) {
        this.cpSeqId = cpSeqId;
    }

    public String getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(String transAmt) {
        this.transAmt = transAmt;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getChkValue() {
        return chkValue;
    }

    public void setChkValue(String chkValue) {
        this.chkValue = chkValue;
    }
}




