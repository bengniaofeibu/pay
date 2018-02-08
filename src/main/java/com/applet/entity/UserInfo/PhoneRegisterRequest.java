package com.applet.entity.UserInfo;

import com.applet.entity.BaseEntity.BaseRequestEntity;

public class PhoneRegisterRequest extends BaseRequestEntity {


    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
