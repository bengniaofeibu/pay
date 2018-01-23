package com.weichuxing.entity.WcxRequest;


public class UserInfoRequest extends BaseWcxRequest {

    /** 用户身份证号 SHA-256**/
    private String userid_hash;

    /** 用户手机号 AES_128_ECB加密  **/
    private String user_mobile;

    /**  车费卡是否有效标识 ，1：有效 2 ：失效 **/
    private String farecard_valid;

    /** 车费卡卡号  **/
    private String farecard_no;


    public String getUserid_hash() {
        return userid_hash;
    }

    public void setUserid_hash(String userid_hash) {
        this.userid_hash = userid_hash;
    }

    public String getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }

    public String getFarecard_valid() {
        return farecard_valid;
    }

    public void setFarecard_valid(String farecard_valid) {
        this.farecard_valid = farecard_valid;
    }

    public String getFarecard_no() {
        return farecard_no;
    }

    public void setFarecard_no(String farecard_no) {
        this.farecard_no = farecard_no;
    }
}
