package com.applet.entity;

import com.applet.Base.BaseEntity;
import com.applet.utils.chinapayutils.SignUtil;
import com.applet.utils.common.JSONUtil;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 有卡交易信息参数
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class CardTranDataParam extends BaseEntity {

    private static final long serialVersionUID = 4885441308232145678L;


    /**
     * 卡号
     **/
    private String CardNo;


    /**
     * 协议号
     **/
    private String Protoco1No;

    /**
     * 证件类型
     **/
    private String CertType;

    /**
     * 证件号
     **/
    private String CertNo;

    /**
     * 姓名
     **/
    private String AccName;

    /**
     * 手机号
     **/
    private String MobileNo;

    /**
     * cvv 渠道需要时才上传
     **/
    private String CVV2;

    /**
     * 卡的有效期
     **/
    private String CardValidityPeriod;

    /**
     * 动态短信码
     **/
    private String MobileAuthCode;

    /**
     * 银联二维码编号
     **/
    private String ProCode;

    /**
     * 商户端用户id
     **/
    private String MerUserId;

    /**
     * cp用户编号
     **/
    private String CpUserId;



    public String getCardNo() {
        return CardNo;
    }

    public void setCardNo(String cardNo) {
        CardNo = cardNo;
    }

    public String getProtoco1No() {
        return Protoco1No;
    }

    public void setProtoco1No(String protoco1No) {
        Protoco1No = protoco1No;
    }

    public String getCertType() {
        return CertType;
    }

    public void setCertType(String certType) {
        CertType = certType;
    }

    public String getCertNo() {
        return CertNo;
    }

    public void setCertNo(String certNo) {
        CertNo = certNo;
    }

    public String getAccName() {
        return AccName;
    }

    public void setAccName(String accName) {
        AccName = accName;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getCVV2() {
        return CVV2;
    }

    public void setCVV2(String CVV2) {
        this.CVV2 = CVV2;
    }

    public String getCardValidityPeriod() {
        return CardValidityPeriod;
    }

    public void setCardValidityPeriod(String cardValidityPeriod) {
        CardValidityPeriod = cardValidityPeriod;
    }

    public String getMobileAuthCode() {
        return MobileAuthCode;
    }

    public void setMobileAuthCode(String mobileAuthCode) {
        MobileAuthCode = mobileAuthCode;
    }

    public String getProCode() {
        return ProCode;
    }

    public void setProCode(String proCode) {
        ProCode = proCode;
    }

    public String getMerUserId() {
        return MerUserId;
    }

    public void setMerUserId(String merUserId) {
        MerUserId = merUserId;
    }

    public String getCpUserId() {
        return CpUserId;
    }

    public void setCpUserId(String cpUserId) {
        CpUserId = cpUserId;
    }

}
