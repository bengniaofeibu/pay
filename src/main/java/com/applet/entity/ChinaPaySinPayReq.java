package com.applet.entity;

import chinapay.PrivateKey;
import chinapay.SecureLink;
import com.applet.Base.BaseEntity;
import com.applet.utils.chinapayutils.PathUtil;
import com.applet.utils.common.Base64Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChinaPaySinPayReq extends BaseEntity {

    private static final long serialVersionUID = 4885441308232145678L;

    private static final String CP_CONFIG_PROPERTIES_PATH="/cp_config.properties";

    private static final SimpleDateFormat DATA_FORMAT=new SimpleDateFormat("yyyyMMdd");

    private static final String CHINA_MERKEY_PATH_NAME="chinapay.merkey.filepath";

    private static String CHINA_MERKEY_PATH;

    /** 商户id **/
    private String merId="808080211881659";

    /** 交易发生的日期 **/
    private String merDate;

    /** 交易订单 **/
    private String merSeqId;

    /** 收款账号 银行卡号或者存折号 **/
    private String cardNo;

    /** 收款人在银行开户时留存的开户姓名 **/
    private String userName;

    /**开户银行名称**/
    private String openBank;

    /**收款人开户行所在省**/
    private String prov;


    /**收款人开户行所在地区**/
    private String city;

    /**金额 单位 分**/
    private String transAmt;

    /**存款用途**/
    private String purpose;

    /**对公对私标记。“00”对私，“01”对公。该字段可以不填，如不填则默认为对私**/
    private String flag;

    /**版本号**/
    private String version="20160530";

    /**签名标志**/
    private String signFlag="1";

    /**渠道类型 07：互联网 8：移动端**/
    private String termType;

    /**交易模式 0：被动发起代付 1：主动发起代付 **/
    private String payMode;

    /**签名值**/
    private String chkValue;



    static {

        PathUtil pathUtil=new PathUtil(CP_CONFIG_PROPERTIES_PATH);
        CHINA_MERKEY_PATH=pathUtil.getValue(CHINA_MERKEY_PATH_NAME);
    }


    public String getMerId() {
        return merId;
    }

    public void setMerId(String merId) {
        this.merId = merId;
    }

    public String getMerDate() {
        return DATA_FORMAT.format(new Date());
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

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(String transAmt) {
        this.transAmt = transAmt;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSignFlag() {
        return signFlag;
    }

    public void setSignFlag(String signFlag) {
        this.signFlag = signFlag;
    }

    public String getTermType() {
        return termType;
    }

    public void setTermType(String termType) {
        this.termType = termType;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public String getChkValue() {
        return chkValue;
    }

    public void setChkValue(String chkValue) {
        this.chkValue = chkValue;
    }


    /**
     * 获取签名
     * @return
     */
    public void getchkSignValue(){

       String plainData= Base64Util.decode(new StringBuilder(this.merId).append(this.merDate)
          .append(this.merSeqId).append(this.cardNo).append(this.userName).append(this.openBank)
          .append(this.prov).append(this.city).append(this.transAmt).append(this.purpose).append(this.flag)
          .append(this.version).append(this.signFlag).append(this.termType).append(this.payMode).toString());

        PrivateKey key = new PrivateKey();
        boolean flage = key.buildKey(merId, 0, CHINA_MERKEY_PATH);
        if(flage == false){
            System.out.println("buildkey error!");
        }else{
            System.out.println("============flage "+flage );
            SecureLink sl = new SecureLink(key);
            System.out.println("====date "+ plainData);
            this.chkValue = sl.Sign(plainData);
            System.out.println("签名内容:"+ this.chkValue);
        }
    }
}




