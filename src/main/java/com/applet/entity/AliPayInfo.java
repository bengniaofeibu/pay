package com.applet.entity;


import com.applet.Base.BaseEntity;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "newAliPay")
public class AliPayInfo extends BaseEntity {

    private static final long serialVersionUID = 4885441308232145678L;

    public static String PAY_ENCODE="utf-8";

    public static String PAY_FORMAT="json";

    public static String PAY_SIGN_TYPE="RSA2";

    public static final String ALI_PAY_URL="https://openapi.alipay.com/gateway.do";

    public static final String QUICK_MSECURITY_PAY="QUICK_MSECURITY_PAY";

    public static final String TRADE_SUCCESS="TRADE_SUCCESS";

    public static final String PAY_WAIT_TIME="30m";

    public static final String RETURN_SUCCESS="success";

    public static final String RETURN_FALSE="false";

    private String appId;

    private String partner;

    private String sellerId;

    private String privateKey;

    private String aliPublicKey;

    private String appPublicKey;

    private String payBackUrl;

    private String smsForRed;




    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getAliPublicKey() {
        return aliPublicKey;
    }

    public void setAliPublicKey(String aliPublicKey) {
        this.aliPublicKey = aliPublicKey;
    }

    public String getAppPublicKey() {
        return appPublicKey;
    }

    public void setAppPublicKey(String appPublicKey) {
        this.appPublicKey = appPublicKey;
    }

    public String getPayBackUrl() {
        return payBackUrl;
    }

    public void setPayBackUrl(String payBackUrl) {
        this.payBackUrl = payBackUrl;
    }


    public String getSmsForRed() {
        return smsForRed;
    }

    public void setSmsForRed(String smsForRed) {
        this.smsForRed = smsForRed;
    }

    public static AliPayResult buildAliPayResult(String body, String payOrder) {

        return new AliPayResult(body,payOrder);
    }

    static class AliPayResult {

        private String aliPaySign;

        private String payOrderId;


        public AliPayResult(String aliPaySign, String payOrderId) {
            this.aliPaySign = aliPaySign;
            this.payOrderId = payOrderId;
        }


        public String getAliPaySign() {
            return aliPaySign;
        }

        public void setAliPaySign(String aliPaySign) {
            this.aliPaySign = aliPaySign;
        }

        public String getPayOrderId() {
            return payOrderId;
        }

        public void setPayOrderId(String payOrderId) {
            this.payOrderId = payOrderId;
        }
    }
}
