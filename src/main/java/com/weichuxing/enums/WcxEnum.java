package com.weichuxing.enums;

public enum WcxEnum implements EnumsService{

    VERIFY_USER_INFO(getMethod,"vcx_mch_check_order_flow.fcgi","查询指定骑行订单");

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
