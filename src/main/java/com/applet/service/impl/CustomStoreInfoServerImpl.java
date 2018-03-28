package com.applet.service.impl;

import com.applet.annotation.SystemServerLog;
import com.applet.entity.Point;
import com.applet.mapper.NyCustomStoreMapper;
import com.applet.model.NyCustomStore;
import com.applet.service.CustomStoreInfoService;
import com.applet.utils.AppletResult;
import com.applet.utils.ResultUtil;
import com.applet.utils.common.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomStoreInfoServerImpl implements CustomStoreInfoService {

    private static final Logger LOGGER= LoggerFactory.getLogger(CustomStoreInfoServerImpl.class);

    @Autowired
    private NyCustomStoreMapper nyCustomStoreMapper;


    /**
     * @param point 车辆经纬度
     * @return
     */
    @SystemServerLog(funcionExplain = "获取商户信息")
    @Override
    public AppletResult getCoustomStoreInfos(Point point) {

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
        return ResultUtil.success(list);
    }
}
