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


    public String getSignStateMsg(int signState){

        String stateMsg=null;
        switch (signState){
            case 00:
             stateMsg="未签约";
            break;
            case 01:
             stateMsg="签约成功";
            break;
            case 02:
             stateMsg="签约名称";
            break;
            case 03:
             stateMsg="已撤销";
            break;
           default:
               stateMsg="未知msg";
        }
      return stateMsg;
    }
}
