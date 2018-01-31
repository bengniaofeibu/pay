package com.weichuxing.entity.LockRequest;

public class OpenLockCallbackRequest extends BaseLockRequest{

    private String openid;

    private String order_id;

    private String bike_id;

    private String model_id;

    private Integer model_type;

    private Integer bike_status;


    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getBike_id() {
        return bike_id;
    }

    public void setBike_id(String bike_id) {
        this.bike_id = bike_id;
    }

    public String getModel_id() {
        return model_id;
    }

    public void setModel_id(String model_id) {
        this.model_id = model_id;
    }

    public Integer getModel_type() {
        return model_type;
    }

    public void setModel_type(Integer model_type) {
        this.model_type = model_type;
    }

    public Integer getBike_status() {
        return bike_status;
    }

    public void setBike_status(Integer bike_status) {
        this.bike_status = bike_status;
    }
}
