package com.applet.service;

import com.applet.entity.Point;
import com.applet.utils.AppletResult;


public interface CustomStoreInfoService {

    /**
     * @param point 车辆经纬度
     * @return
     */
    AppletResult getCoustomStoreInfos(Point point);
}
