package com.applet.entity.LockResponse;

public class QueryRidingStatusResponse extends BaseLockResponse{

    private Integer ridingFlag;

    private long ridingTime;

    private Integer ridingCost;

    public Integer getRidingFlag() {
        return ridingFlag;
    }

    public void setRidingFlag(Integer ridingFlag) {
        this.ridingFlag = ridingFlag;
    }

    public long getRidingTime() {
        return ridingTime;
    }

    public void setRidingTime(long ridingTime) {
        this.ridingTime = ridingTime;
    }

    public Integer getRidingCost() {
        return ridingCost;
    }

    public void setRidingCost(Integer ridingCost) {
        this.ridingCost = ridingCost;
    }
}
