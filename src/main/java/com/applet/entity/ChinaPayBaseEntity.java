package com.applet.entity;


import com.applet.utils.chinapayutils.SignUtil;
import com.applet.utils.common.JSONUtil;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


/**
 * 银联公共参数
 */
public  class ChinaPayBaseEntity extends CardTranDataParam {


    private static final long serialVersionUID = 4885441308232145678L;

    private static final Logger LOGGER = LoggerFactory.getLogger(ChinaPayBaseEntity.class);

    private static final SimpleDateFormat DATE_FORMAT=new SimpleDateFormat("yyyyMMdd");

    private static final SimpleDateFormat TIME_FORMAT=new SimpleDateFormat("HHmmss");


    /**
     * 版本号
     **/
    private String Version = "20150922";

    /**
     * 接入类型
     **/
    private String AccessType = "0";

    /**
     * 接入机构代码号
     **/
    private String InstuId;

    /**
     * 收单机构号
     **/
    private String AcqCode;

    /**
     * 商户号
     **/
    private String MerId = "000001805302425";

    /**
     * 业务类型 固定值0001
     **/
    private String BusiType = "0001";

    /**
     * 交易币种
     */
    private String CurryNo;

    /**
     * 订单支付状态
     */
    private String OrderStatus;

    /**
     * 分账类型
     */
    private String SplitType;

    /**
     * 分账方式
     */
    private String SplitMethod;

    /**
     * 分账信息
     */
    private String MerSplitMsg;

    /**
     * 收单流水号
     */
    private String AcqSeqId;


    /**
     * 收单日期
     */
    private String AcqDate;


    /**
     * 渠道流水号
     */
    private String ChannelSeqId;


    /**
     * 渠道日期
     */
    private String ChannelDate;



    /**
     * 渠道时间
     */
    private String ChannelTime;


    /**
     * 支付账单号
     */
    private String PayBillNo;


    /**
     * 收支付机构号
     */
    private String BankInstNo;


    /**
     * 商品信息
     */
    private String CommodityMsg;

    /**
     * 支付超时时间
     */
    private String PayTimeOut;


    /**
     * 防钓鱼时间戳
     */
    private String TimeStamp;


    /**
     * 订单完成日期
     */
    private String CompleteDate;


    /**
     * 订单完成时间
     */
    private String CompleteTime;


    /**
     * 待查交易类型  快捷签约9904 快捷支付0004
     **/
    private String OriTranType = "9904";

    /**
     * 交易类型
     **/
    private String TranType;

    /**
     * 支付机构号
     **/
    private Integer BankInsNo;

    /**
     * 有卡交易信息域
     **/
    private String CardTranData;


    /**
     * 商户订单号
     **/
    private String MerOrderNo;

    /**
     * 商户交易日期
     **/
    private String TranDate;

    /**
     * 商户交易时间
     **/
    private String TranTime;

    /**
     * 客户端ip
     **/
    private String RemoteAddr;


    /**
     * 支付金额
     */
    private String OrderAmt;


    /**
     * 风控数据
     **/
    private String RiskData;

    /**
     * 交易扩展域
     **/
    private String TranReserved;

    /**
     * 签名
     **/
    private String Signature;


    public ChinaPayBaseEntity() {
    }



    public static class Builder{

        private String MerOrderNo;

        private String OrderAmt;

        private String CardNo;

        private String MobileAuthCode;

        private String MerSplitMsg;

        public Builder(){

        }

        public Builder setMerOrderNo(String merOrderNo){
            this.MerOrderNo=merOrderNo;
            return this;
        }

        public Builder setOrderAmt(String orderAmt){
            this.OrderAmt=orderAmt;
            return this;
        }

        public Builder setCardNo(String cardNo){
            this.CardNo=cardNo;
            return this;
        }

        public Builder setMobileAuthCode(String mobileAuthCode){
            this.MobileAuthCode=mobileAuthCode;
            return this;
        }

        public Builder setMerSplitMsg(String merSplitMsg){
            this.MerSplitMsg=merSplitMsg;
            return this;
        }

       public ChinaPayBaseEntity build(){
            return new ChinaPayBaseEntity(this);
       }

    }

    private ChinaPayBaseEntity(Builder builder){
        this.setCardNo(builder.CardNo);
        this.setOrderAmt(builder.OrderAmt);
        this.setMerOrderNo(builder.MerOrderNo);
        this.setMerSplitMsg(builder.MerSplitMsg);
        this.setMobileAuthCode(builder.MobileAuthCode);
    }


    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getAccessType() {
        return AccessType;
    }

    public void setAccessType(String accessType) {
        AccessType = accessType;
    }

    public String getInstuId() {
        return InstuId;
    }

    public void setInstuId(String instuId) {
        InstuId = instuId;
    }

    public String getAcqCode() {
        return AcqCode;
    }

    public void setAcqCode(String acqCode) {
        AcqCode = acqCode;
    }

    public String getMerId() {
        return MerId;
    }

    public void setMerId(String merId) {
        MerId = merId;
    }

    public String getBusiType() {
        return BusiType;
    }

    public void setBusiType(String busiType) {
        BusiType = busiType;
    }

    public String getOriTranType() {
        return OriTranType;
    }

    public void setOriTranType(String OriTranType) {
        this.OriTranType = OriTranType;
    }

    public String getTranType() {
        return TranType;
    }

    public void setTranType(String tranType) {
        TranType = tranType;
    }

    public Integer getBankInsNo() {
        return BankInsNo;
    }

    public void setBankInsNo(Integer bankInsNo) {
        BankInsNo = bankInsNo;
    }

    public String getCardTranData() {
        return CardTranData;
    }

    public void setCardTranData(String cardTranData) {
        CardTranData = cardTranData;
    }

    public String getCurryNo() {
        return CurryNo;
    }

    public void setCurryNo(String curryNo) {
        CurryNo = curryNo;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        OrderStatus = orderStatus;
    }

    public String getSplitType() {
        return SplitType;
    }

    public void setSplitType(String splitType) {
        SplitType = splitType;
    }

    public String getSplitMethod() {
        return SplitMethod;
    }

    public void setSplitMethod(String splitMethod) {
        SplitMethod = splitMethod;
    }

    public String getMerSplitMsg() {
        return MerSplitMsg;
    }

    public void setMerSplitMsg(String merSplitMsg) {
        MerSplitMsg = merSplitMsg;
    }

    public String getAcqSeqId() {
        return AcqSeqId;
    }

    public void setAcqSeqId(String acqSeqId) {
        AcqSeqId = acqSeqId;
    }

    public String getAcqDate() {
        return AcqDate;
    }

    public void setAcqDate(String acqDate) {
        AcqDate = acqDate;
    }

    public String getChannelSeqId() {
        return ChannelSeqId;
    }

    public void setChannelSeqId(String channelSeqId) {
        ChannelSeqId = channelSeqId;
    }

    public String getChannelDate() {
        return ChannelDate;
    }

    public void setChannelDate(String channelDate) {
        ChannelDate = channelDate;
    }

    public String getChannelTime() {
        return ChannelTime;
    }

    public void setChannelTime(String channelTime) {
        ChannelTime = channelTime;
    }

    public String getPayBillNo() {
        return PayBillNo;
    }

    public void setPayBillNo(String payBillNo) {
        PayBillNo = payBillNo;
    }

    public String getBankInstNo() {
        return BankInstNo;
    }

    public void setBankInstNo(String bankInstNo) {
        BankInstNo = bankInstNo;
    }

    public String getCommodityMsg() {
        return CommodityMsg;
    }

    public void setCommodityMsg(String commodityMsg) {
        CommodityMsg = commodityMsg;
    }

    public String getPayTimeOut() {
        return PayTimeOut;
    }

    public void setPayTimeOut(String payTimeOut) {
        PayTimeOut = payTimeOut;
    }

    public String getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        TimeStamp = timeStamp;
    }

    public String getCompleteDate() {
        return CompleteDate;
    }

    public void setCompleteDate(String completeDate) {
        CompleteDate = completeDate;
    }

    public String getCompleteTime() {
        return CompleteTime;
    }

    public void setCompleteTime(String completeTime) {
        CompleteTime = completeTime;
    }

    public String getMerOrderNo() {
        return MerOrderNo;
    }

    public void setMerOrderNo(String merOrderNo) {
        MerOrderNo = merOrderNo;
    }

    public String getTranDate() {
        return DATE_FORMAT.format(new Date());
    }

    public void setTranDate(String tranDate) {
        TranDate = tranDate;
    }

    public String getTranTime() {
        return TIME_FORMAT.format(new Date());
    }

    public void setTranTime(String tranTime) {
        TranTime = tranTime;
    }

    public String getRemoteAddr() {
        return RemoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        RemoteAddr = remoteAddr;
    }


    public String getOrderAmt() {
        return OrderAmt;
    }

    public void setOrderAmt(String orderAmt) {
        OrderAmt = orderAmt;
    }

    public String getRiskData() {
        return RiskData;
    }

    public void setRiskData(String riskData) {
        RiskData = riskData;
    }

    public String getTranReserved() {
        return TranReserved;
    }

    public void setTranReserved(String tranReserved) {
        TranReserved = tranReserved;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }


    /**
     * 加密有卡交易信息域
     *
     * @return
     */
    public String getCardTranDataEncryptData() {

        CardTranDataParam cardTranDataParam=new CardTranDataParam();
        cardTranDataParam.setCardNo(this.getCardNo());
        cardTranDataParam.setAccName(this.getAccName());
        cardTranDataParam.setCertType(this.getCertType());
        cardTranDataParam.setCertNo(this.getCertNo());
        cardTranDataParam.setMobileNo(this.getMobileNo());
        cardTranDataParam.setMobileAuthCode(this.getMobileAuthCode());
        return JSONUtil.toJSONString(cardTranDataParam);
    }



    /**
     * 生成请求参数
     *
     * @param chinaPayBaseEntity
     * @return
     */
    public Map getSendMap(ChinaPayBaseEntity chinaPayBaseEntity) {

        try {
            if (chinaPayBaseEntity != null) {
                String encryptData = getCardTranDataEncryptData();
                if (!StringUtils.isBlank(encryptData)) {
                    chinaPayBaseEntity.setCardTranData(encryptData);
                }

                Map sendMap = JSONUtil.objectToMap(chinaPayBaseEntity);
                sendMap.put("Signature", SignUtil.sign(sendMap));
                return sendMap;
            }

        } catch (Exception e) {
            LOGGER.error("生成请求参数 ERROR {}", e);
            return null;
        }
        return null;
    }


}
