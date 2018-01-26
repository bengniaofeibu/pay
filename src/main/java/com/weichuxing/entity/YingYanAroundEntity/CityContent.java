package com.weichuxing.entity.YingYanAroundEntity;

public class CityContent {

    private AddressDetail address_detail;

    private  String address;

    private Point point;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AddressDetail getAddress_detail() {
        return address_detail;
    }

    public void setAddress_detail(AddressDetail address_detail) {
        this.address_detail = address_detail;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
