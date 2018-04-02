package com.applet.service.impl;

import com.applet.annotation.SystemServerLog;
import com.applet.entity.MerchantsInfo;
import com.applet.entity.StorePoint;
import com.applet.entity.StoreTypeDetails;
import com.applet.entity.StoreTypes;
import com.applet.mapper.NyCustomStoreMapper;
import com.applet.model.NyCustomStore;
import com.applet.service.CustomStoreInfoService;
import com.applet.utils.AppletResult;
import com.applet.utils.ResultUtil;
import com.applet.utils.common.JSONUtil;
import com.applet.utils.common.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class CustomStoreInfoServerImpl implements CustomStoreInfoService {

    private static final Logger LOGGER= LoggerFactory.getLogger(CustomStoreInfoServerImpl.class);

    @Autowired
    private NyCustomStoreMapper nyCustomStoreMapper;

    @Autowired
    private RedisUtil redisUtil;


    /**
     * 获取门店类型
     *
     * @return
     */
    @SystemServerLog(funcionExplain = "获取门店类型")
    @Override
    public AppletResult getCoustomStoreType() {

        List<MerchantsInfo> merchantsInfoLists=new LinkedList<>();
        merchantsInfoLists.add(new MerchantsInfo("AAAA","早餐",1));
        merchantsInfoLists.add(new MerchantsInfo("BBBB","家政",2));

        return ResultUtil.success(merchantsInfoLists);
    }

    /**
     * @param point 车辆经纬度
     * @return
     */
    @SystemServerLog(funcionExplain = "获取商户信息")
    @Override
    public AppletResult getCoustomStoreInfos(StorePoint point) {

        List<NyCustomStore> nyCustomStores = nyCustomStoreMapper.selectCustomStores();
        LOGGER.debug("nycustomstores {}", JSONUtil.toJSONString(nyCustomStores));


        NyCustomStore nyCustomStore=new NyCustomStore();
        nyCustomStore.setStoreName("门店名称1");
        nyCustomStore.setLongitude("121.240854");
        nyCustomStore.setLatitude("31.011265");
        nyCustomStore.setCoustomType(1);
        nyCustomStore.setIsEnlarge(1);
        nyCustomStore.setDistance(200);
        nyCustomStore.setTime(20);

        NyCustomStore nyCustomStore2=new NyCustomStore();
        nyCustomStore2.setStoreName("门店名称2");
        nyCustomStore2.setLongitude("1.211");
        nyCustomStore2.setLatitude("1.611");
        nyCustomStore2.setCoustomType(2);
        nyCustomStore2.setIsEnlarge(0);
        nyCustomStore2.setDistance(200);
        nyCustomStore2.setTime(20);

        List<NyCustomStore> list=new ArrayList<>();
        list.add(nyCustomStore);
        list.add(nyCustomStore2);

        long count = redisUtil.addGeoPoint("custorm:point:", new org.springframework.data.geo.Point(12.0131, 31.0111), "上海");
        System.out.println(count);
        return ResultUtil.success(list);
    }

    /**
     * 获取商家详情
     *
     * @param storeId 商家id
     * @param userId   用户id
     * @return
     */
    @SystemServerLog(funcionExplain = "获取商家详情")
    @Override
    public AppletResult getMerchantsDetails(String storeId, String userId) {

           List<String> urls=new LinkedList<>();
           urls.add("url1");
           urls.add("url2");

        return ResultUtil.success(new MerchantsInfo(urls,500L,"h5url","早餐店"));
    }

    /**
     * 获取商店分类详情
     *
     * @param customType
     * @param userId
     * @return
     */
    @SystemServerLog(funcionExplain = "获取商家分类详情")
    @Override
    public AppletResult customClassifyDetails(Integer customType, String userId) {

        List<StoreTypes> list=new LinkedList<>();
        List<StoreTypeDetails> detailsList=new LinkedList<>();
        detailsList.add(new StoreTypeDetails("image1","描述信息",null,null,null));
        detailsList.add(new StoreTypeDetails("image2","描述信息",null,null,null));
        detailsList.add(new StoreTypeDetails("image3","描述信息",null,null,null));
        list.add(new StoreTypes(detailsList,1,"推荐"));

        List<StoreTypeDetails> detailsList1=new LinkedList<>();
        detailsList1.add(new StoreTypeDetails("image1","描述信息","地址",500L,4544L));
        detailsList1.add(new StoreTypeDetails("image2","描述信息","地址",500L,4544L));
        detailsList1.add(new StoreTypeDetails("image3","描述信息","地址",500L,4544L));
        list.add(new StoreTypes(detailsList1,2,"探店"));


        List<StoreTypeDetails> detailsList2=new LinkedList<>();
        detailsList2.add(new StoreTypeDetails("image1","描述信息","地址",500L,4544L));
        detailsList2.add(new StoreTypeDetails("image2","描述信息","地址",500L,4544L));
        detailsList2.add(new StoreTypeDetails("image3","描述信息","地址",500L,4544L));
        list.add(new StoreTypes(detailsList2,3,"保洁"));


        List<StoreTypeDetails> detailsList3=new LinkedList<>();
        detailsList3.add(new StoreTypeDetails("image1","描述信息","地址",500L,4544L));
        detailsList3.add(new StoreTypeDetails("image2","描述信息","地址",500L,4544L));
        detailsList3.add(new StoreTypeDetails("image3","描述信息","地址",500L,4544L));
        list.add(new StoreTypes(detailsList3,4,"推荐"));

        return ResultUtil.success(list);
    }
}
