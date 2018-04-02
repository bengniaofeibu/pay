package com.applet.service;

import com.applet.entity.StorePoint;
import com.applet.utils.AppletResult;
import com.sun.jersey.core.impl.provider.entity.XMLRootObjectProvider;


public interface CustomStoreInfoService {

    /**
     * 获取首页门店信息
     * @param point 车辆经纬度
     * @return
     */
    AppletResult getCoustomStoreInfos(StorePoint point);


    /**
     * 获取门店类型
     * @return
     */
    AppletResult getCoustomStoreType();


    /**
     * 获取商家详情
     * @param storeId 商家id
     * @param userId 用户id
     * @return
     */
    AppletResult getMerchantsDetails(String storeId,String userId);

    /**
     * 获取商店分类详情
     *
     * @return
     */
    AppletResult customClassifyDetails(Integer customType, String userId);

}
