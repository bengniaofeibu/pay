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

    /** 删除标识 **/
    private Short delFlag;

    /** 数据添加时间 **/
    private Date addTime;

    /**  数据更新时间 **/
    private Date updateTime;


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
}