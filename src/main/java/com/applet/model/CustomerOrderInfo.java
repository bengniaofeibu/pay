package com.applet.model;

import com.applet.Base.BaseModel;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerOrderInfo extends BaseOrderInfo{

    private static final long serialVersionUID = 5895699582957353403L;

    private Long id;

    /** 用户id **/
    private String userId;

    /** 订单商品id **/
    private String orderGoodsId;

    /** 订单商品数量 **/
    private Integer goodsNum;

    /** 服务上门时间 （某些订单会有）**/
    private Date serverTime;

    /** 服务时长 （某些订单会有） **/
    private Double serverTheLength;

    /** 用户支付账号 **/
    private String userPayNumber;

    /** 订单唯一号 **/
    private String orderNumber;

    /** 银联订单号 **/
    private String merOrderNo;

    /**
     *  银联支付金额
     */
    private String orderAmt;

    /**
     *  银行卡号
     */
    private String cardNo;

    /**
     *  银联短信验证码
     */
    private String mobileAuthCode;


    /**
     *  银联分账信息
     */
    private String merSplitMsg;

    /** 订单用途 **/
    private String orderSubject;

    /**  支付订单号 （第三方回调得到） **/
    private String tradeNo;

    /**  待支付支付金额 **/
    private BigDecimal payAmount;

    /** 实际支付金额 **/
    private BigDecimal totalAmount;

    /** 优惠金额 **/
    private BigDecimal discountAmount;

    /** 商品金额 **/
    private BigDecimal goodsAmount;

    /**  支付方式 **/
    private Short payWay;

    /** 订单状态（1: 待支付 2:已支付(未完成) 3:已完成 4:已取消 ） **/
    private Short payStatus;

    /** 商品类型 **/
    private Short goodsType;


    private Date refundTime;

    private String refundReason;

    /** 删除标识 **/
    private Short delFlag;

    private Date createDate;

    private String createBy;

    /** 数据添加时间 **/
    private Date addTime;

    /**  数据更新时间 **/
    private Date updateTime;

    private Date updateDate;

    private String updateBy;

    private String takefoodCode;

    private String jiumiAmount;

    private String couponNo;

    private String couponAmount;

    private String hbAmount;

    private String lbAmount;

    private String feeAmount;

    private String commissionAmount;

    private String settlementAmount;


    public CustomerOrderInfo() {
    }

    public static CustomerOrderInfo buildPayInstance(){
       return new CustomerOrderInfo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(String orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Date getServerTime() {
        return serverTime;
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
    }

    public Double getServerTheLength() {
        return serverTheLength;
    }

    public void setServerTheLength(Double serverTheLength) {
        this.serverTheLength = serverTheLength;
    }

    @Override
    public String getUserPayNumber() {
        return userPayNumber;
    }

    @Override
    public void setUserPayNumber(String userPayNumber) {
        this.userPayNumber = userPayNumber;
    }

    @Override
    public String getOrderNumber() {
        return orderNumber;
    }

    @Override
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderSubject() {
        return orderSubject;
    }

    public String getMerOrderNo() {
        return merOrderNo;
    }

    public void setMerOrderNo(String merOrderNo) {
        this.merOrderNo = merOrderNo;
    }

    public String getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(String orderAmt) {
        this.orderAmt = orderAmt;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getMobileAuthCode() {
        return mobileAuthCode;
    }

    public void setMobileAuthCode(String mobileAuthCode) {
        this.mobileAuthCode = mobileAuthCode;
    }

    public String getMerSplitMsg() {
        return merSplitMsg;
    }

    public void setMerSplitMsg(String merSplitMsg) {
        this.merSplitMsg = merSplitMsg;
    }

    public void setOrderSubject(String orderSubject) {
        this.orderSubject = orderSubject;
    }

    @Override
    public String getTradeNo() {
        return tradeNo;
    }

    @Override
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public Short getPayWay() {
        return payWay;
    }

    public void setPayWay(Short payWay) {
        this.payWay = payWay;
    }

    public Short getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Short payStatus) {
        this.payStatus = payStatus;
    }

    public Short getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Short goodsType) {
        this.goodsType = goodsType;
    }

    public Short getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Short delFlag) {
        this.delFlag = delFlag;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getTakefoodCode() {
        return takefoodCode;
    }

    public void setTakefoodCode(String takefoodCode) {
        this.takefoodCode = takefoodCode;
    }

    public String getJiumiAmount() {
        return jiumiAmount;
    }

    public void setJiumiAmount(String jiumiAmount) {
        this.jiumiAmount = jiumiAmount;
    }

    public String getCouponNo() {
        return couponNo;
    }

    public void setCouponNo(String couponNo) {
        this.couponNo = couponNo;
    }

    public String getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(String couponAmount) {
        this.couponAmount = couponAmount;
    }

    public String getHbAmount() {
        return hbAmount;
    }

    public void setHbAmount(String hbAmount) {
        this.hbAmount = hbAmount;
    }

    public String getLbAmount() {
        return lbAmount;
    }

    public void setLbAmount(String lbAmount) {
        this.lbAmount = lbAmount;
    }

    public String getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(String feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(String commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public String getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(String settlementAmount) {
        this.settlementAmount = settlementAmount;
    }
}