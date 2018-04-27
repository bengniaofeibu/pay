package com.applet.entity;

import com.applet.Base.BaseEntity;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "wxPay")
public class WxPayInfo extends BaseEntity {

    private static final long serialVersionUID = 4885441308232145678L;

    public static final String SPBILL_CREATE_IP="172.0.0.1";

    public static final String TRADE_TYPE="APP";

    public static final String WX_PAY_URL="https://api.mch.weixin.qq.com/pay/unifiedorder";

    public static final String CALL_BACK_SUCCESS="SUCCESS";

    public static final String CALL_BACK_FAIL="FAIL";

    private String appId;

    private String mchId;

    private String key;

    private String packageSign;

    private String payBackUrl;

    private String refundUrl;

    private String transferUrl;

    private String cer;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPackageSign() {
        return packageSign;
    }

    public void setPackageSign(String packageSign) {
        this.packageSign = packageSign;
    }

    public String getPayBackUrl() {
        return payBackUrl;
    }

    public void setPayBackUrl(String payBackUrl) {
        this.payBackUrl = payBackUrl;
    }

    public String getRefundUrl() {
        return refundUrl;
    }

    public void setRefundUrl(String refundUrl) {
        this.refundUrl = refundUrl;
    }

    public String getTransferUrl() {
        return transferUrl;
    }

    public void setTransferUrl(String transferUrl) {
        this.transferUrl = transferUrl;
    }

    public String getCer() {
        return cer;
    }

    public void setCer(String cer) {
        this.cer = cer;
    }
}
