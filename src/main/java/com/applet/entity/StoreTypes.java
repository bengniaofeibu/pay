package com.applet.entity;

import com.applet.Base.BaseEntity;

import java.util.List;

public class StoreTypes extends BaseEntity {

    private static final long serialVersionUID = 4885441308232145678L;

    /** 类型集合 **/
    private List<StoreTypeDetails> storeTypeDetails;

    /** 商家类型 **/
    private int storeType;

    /** 商家类型名称 **/
    private String storeName;


    public StoreTypes() {
    }

    public StoreTypes(List<StoreTypeDetails> storeTypeDetails, int storeType, String storeName) {
        this.storeTypeDetails = storeTypeDetails;
        this.storeType = storeType;
        this.storeName = storeName;
    }

    public List<StoreTypeDetails> getStoreTypeDetails() {
        return storeTypeDetails;
    }

    public void setStoreTypeDetails(List<StoreTypeDetails> storeTypeDetails) {
        this.storeTypeDetails = storeTypeDetails;
    }

    public int getStoreType() {
        return storeType;
    }

    public void setStoreType(int storeType) {
        this.storeType = storeType;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public String toString() {
        return "StoreTypes{" +
                "storeTypeDetails=" + storeTypeDetails +
                ", storeType=" + storeType +
                ", storeName='" + storeName + '\'' +
                '}';
    }
}
