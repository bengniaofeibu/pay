package com.weichuxing.enums;

public enum WcxEnum implements EnumsService{

    VERIFY_USER_INFO(getMethod,"vcx_mch_check_order_flow.fcgi","查询指定骑行订单"),

    CHECK_ACCOUNT_DAY(getMethod,"vcx_mch_check_account_day.fcgi","查询某日对账情况"),

    OPEN_LOCK_CALLBACK(getMethod,"vcx_mch_callback_bike_unlock.fcgi","扫码开锁回调"),

    CLOSE_LOCK_CALLBACK(getMethod,"vcx_mch_callback_bike_finish.fcgi","关锁回调"),

    RET_DEPOSIT_APPLY(postMethod,"vcx_mch_ret_deposit_apply.fcgi","微出行交纳押金退回申请");

    String reqMethod;

    String reqUrl;

    String serviceName;

    WcxEnum(String reqMethod, String reqUrl, String serviceName) {
        this.reqMethod = reqMethod;
        this.reqUrl = reqUrl;
        this.serviceName = serviceName;
    }

    public String getReqMethod() {
        return reqMethod;
    }

    public void setReqMethod(String reqMethod) {
        this.reqMethod = reqMethod;
    }

    public String getReqUrl() {
        return reqUrl;
    }

    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
