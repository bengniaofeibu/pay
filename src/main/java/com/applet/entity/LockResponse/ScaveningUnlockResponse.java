package com.applet.entity.LockResponse;

public class ScaveningUnlockResponse extends BaseLockResponse{

    private String userId;

    private String transId;

    private String borrowDataTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getBorrowDataTime() {
        return borrowDataTime;
    }

    public void setBorrowDataTime(String borrowDataTime) {
        this.borrowDataTime = borrowDataTime;
    }
}
