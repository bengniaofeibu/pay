package com.applet.controller;

import com.applet.Base.BaseController;
import com.applet.entity.Point;
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

    @PostMapping(value = "/query/customstoreinfo")
    public AppletResult getCustomStoreInfo(Point point){

        return  customStoreInfoService.getCoustomStoreInfos(point);
    }
}
