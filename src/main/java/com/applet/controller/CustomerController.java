package com.applet.controller;

import com.applet.Base.BaseController;
import com.applet.annotation.SystemControllerLog;
import com.applet.entity.StorePoint;
import com.applet.service.CustomerInfoService;
import com.applet.utils.AppletResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cser")
public class CustomerController extends BaseController {

    //商户接口
    @Autowired
    private CustomerInfoService customerInfoService;


    /**
     * 获取客户地址
     * @param userId
     * @return
     */
    @SystemControllerLog(funcionExplain = "进入获取客户地址控制层")
    @PostMapping(value = "/query/customerAddress")
    public AppletResult getCustomerAddress(String userId){

        return  customerInfoService.getCustomerAddress(userId);
    }
}
