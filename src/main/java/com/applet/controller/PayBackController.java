package com.applet.controller;

import com.applet.Base.BaseController;
import com.applet.annotation.SystemControllerLog;
import com.applet.entity.ChinaPayBaseEntity;
import com.applet.service.StoreOrderUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/payback")
public class PayBackController extends BaseController {


    @SystemControllerLog(funcionExplain = "进入阿里支付回调控制层")
    @PostMapping(value = "/alipayback")
    public String aliPayBack(HttpServletRequest request){
       return aliPayService.payBack(request);
    }

    @SystemControllerLog(funcionExplain = "进入微信支付回调控制层")
    @PostMapping(value = "/wxpayback")
    public String wxPayBack(HttpServletRequest request){
            return wxPayService.payBack(request);
    }

    @SystemControllerLog(funcionExplain = "进入银联支付回调控制层")
    @PostMapping(value = "/chinapayback")
    public String chinaPayBack(ChinaPayBaseEntity chinaPayBaseEntity){
        return chinaPayService.chinaPayBack(chinaPayBaseEntity);
    }

}
