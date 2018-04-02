package com.applet.controller;

import com.applet.Base.BaseController;
import com.applet.annotation.SystemControllerLog;
import com.applet.annotation.SystemServerLog;
import com.applet.entity.StorePoint;
import com.applet.service.CustomStoreInfoService;
import com.applet.utils.AppletResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cs")
public class CustomStoreController extends BaseController {

    //商户接口
    @Autowired
    private CustomStoreInfoService customStoreInfoService;


    /**
     * 获取首页商家信息
     * @param point
     * @return
     */
    @SystemControllerLog(funcionExplain = "进入获取商户信息控制层")
    @PostMapping(value = "/query/customstoreinfo")
    public AppletResult getCustomStoreInfo(@RequestBody StorePoint point){

        return  customStoreInfoService.getCoustomStoreInfos(point);
    }


    /**
     * 获取门店类型
     * @return
     */
    @SystemControllerLog(funcionExplain = "进入获取门店类型控制层")
    @PostMapping(value = "/query/coustomStoreType")
    public AppletResult getCoustomStoreType(){

        return  customStoreInfoService.getCoustomStoreType();
    }


    /**
     * 商家详情
     * @param storeId
     * @param userId
     * @return
     */
    @SystemControllerLog(funcionExplain = "进入获取商家详情控制层")
    @PostMapping(value = "/query/merchantsDetailed")
    public AppletResult getMerchantsDetails(String storeId,String userId) {

        return customStoreInfoService.getMerchantsDetails(storeId, userId);

    }

    /**
     * 获取商家分类详情
     * @param customType
     * @param userId
     * @return
     */
    @SystemControllerLog(funcionExplain = "进入获取商家分类详情控制层")
    @PostMapping(value = "/query/customClassifyDetails")
    public AppletResult getCoustomClassifyDetails(Integer customType,String userId) {

        return customStoreInfoService.customClassifyDetails(customType, userId);

    }
}
