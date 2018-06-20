package com.applet.entity;



public abstract class ChinaPayResBaseEntity extends ChinaPayBaseEntity {

    private static final long serialVersionUID = 4885441308232145678L;

    /** 响应信息 **/
    private String respMsg;

    /** 响应码 **/
    private Integer respCode;

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public Integer getRespCode() {
        return respCode;
    }

    public void setRespCode(Integer respCode) {
        this.respCode = respCode;
    }
}
