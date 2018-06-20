package com.applet.Request;

import com.applet.model.CustomerOrderInfo;


public class UserPayReq extends CustomerOrderInfo{

    private static final long serialVersionUID = 5895699582957353403L;

    /** 优惠劵Id **/
    private String couponId;

    /**
     *  1 只使用了积分
     *  2 只使用了红包
     *  3 使用了优惠劵
     *  4 使用了积分和红包
     *  5 使用了积分和优惠劵
     *  6 使用红包和优惠劵
     *  7 使用积分，红包和优惠劵
     *  **/
    private Integer couponFlag;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public Integer getCouponFlag() {
        return couponFlag;
    }

    public void setCouponFlag(Integer couponFlag) {
        this.couponFlag = couponFlag;
    }
}
