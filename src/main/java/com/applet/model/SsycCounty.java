package com.applet.model;

import com.applet.Base.BaseModel;

public class SsycCounty extends BaseModel{

    private static final long serialVersionUID = 5895699582957353403L;

    private Integer id;

    private Long cityId;

    private Long countyId;

    private String countyName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName == null ? null : countyName.trim();
    }
}