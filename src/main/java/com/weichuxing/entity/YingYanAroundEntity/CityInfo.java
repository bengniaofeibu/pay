package com.weichuxing.entity.YingYanAroundEntity;

public class CityInfo {

    private String address;

    private CityContent content;

    private Integer status;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public CityContent getContent() {
        return content;
    }

    public void setContent(CityContent content) {
        this.content = content;
    }
}
