package com.weichuxing.entity.WcxRequest;


public class UserInfoRequest extends BaseWcxRequest {

    private String userid_hash;

    private String user_mobile;

    private String farecard_valid;

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
