package com.applet.entity.LockRequest;

public class QueryRidingStatusRequest extends BaseLockRequest{

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
