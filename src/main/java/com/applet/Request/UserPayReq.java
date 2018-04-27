package com.applet.Request;

import com.applet.model.CustomerOrderInfo;


public class UserPayReq extends CustomerOrderInfo{

    private static final long serialVersionUID = 5895699582957353403L;

    /** 优惠劵Id **/
    private String couponId;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }
}
