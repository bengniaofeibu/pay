package com.applet.entity;

public class PhoneRegisterRequest extends  RequestEntity {

    private String session;

    private String phone;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
