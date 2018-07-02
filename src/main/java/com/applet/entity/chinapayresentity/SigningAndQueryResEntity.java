package com.applet.entity.chinapayresentity;

import com.applet.entity.ChinaPayResBaseEntity;

public class SigningAndQueryResEntity extends ChinaPayResBaseEntity {

    /**
     * 签约状态
     * <p>
     * 00 未签约
     * 01 签约成功
     * 02 签约失败
     * 03 已撤销
     * </p>
     **/
    private Integer SignState;

    public Integer getSignState() {
        return SignState;
    }

    public void setSignState(Integer signState) {
        SignState = signState;
    }
}
