package com.weichuxing.entity.WcxRequest;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseWcxRequest {

    /**  微出行平台ID  **/
    protected  String openId;

    /** 版本号 **/
    protected String version;

    /**  随机串  **/
    protected String nonce_str;

    /** 腾讯财付通商户号(可能为手Q支付商户号 ，也可能是微信支付商户号)**/
    protected String sp_id;

    /**  腾讯财付通秘钥(可能为手Q支付商户号 ，也可能是微信支付商户号)**/
    protected String key;

    /**  签名参数  **/
    protected String sign;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSp_id() {
        return sp_id;
    }

    public void setSp_id(String sp_id) {
        this.sp_id = sp_id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

}
