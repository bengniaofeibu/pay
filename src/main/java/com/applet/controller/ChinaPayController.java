package com.applet.controller;

import com.applet.Base.BaseController;
import com.applet.annotation.SystemControllerLog;
import com.applet.entity.CardTranDataParam;
import com.applet.entity.ChinaPayBaseEntity;
import com.applet.entity.ChinaPaySinPayReq;
import com.applet.service.ChinaPayService;
import com.applet.utils.AppletResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/chinapay")
public class ChinaPayController extends BaseController{


    @Autowired
    private ChinaPayService chinaPayService;

    @SystemControllerLog(funcionExplain = "进入签约查询控制层")
    @PostMapping(value = "/signgingandquery")
    public AppletResult signgingAndQuery(@RequestBody ChinaPayBaseEntity chinaPayBaseEntity){

      return chinaPayService.signgingAndQuery(chinaPayBaseEntity);
    }

    @SystemControllerLog(funcionExplain = "进入交易要素查询控制层")
    @PostMapping(value = "/tradingelementsquery")
    public AppletResult tradingElementsQuery(@RequestBody ChinaPayBaseEntity chinaPayBaseEntity){
        return chinaPayService.tradingElementsQuery(chinaPayBaseEntity);
    }

    @SystemControllerLog(funcionExplain = "进入签约短信控制层")
    @PostMapping(value = "/signingSms")
    public AppletResult signingSms(@RequestBody ChinaPayBaseEntity chinaPayBaseEntity){
        return chinaPayService.signingSms(chinaPayBaseEntity);
    }

    @SystemControllerLog(funcionExplain = "进入签约控制层")
    @PostMapping(value = "/signing")
    public AppletResult signing(@RequestBody ChinaPayBaseEntity chinaPayBaseEntity){
        return chinaPayService.signing(chinaPayBaseEntity);
    }

    @SystemControllerLog(funcionExplain = "进入解约控制层")
    @PostMapping(value = "/unsigning")
    public AppletResult unSigning(@RequestBody ChinaPayBaseEntity chinaPayBaseEntity){
        return chinaPayService.unSigning(chinaPayBaseEntity);
    }

    @SystemControllerLog(funcionExplain = "进入支付短信控制层")
    @PostMapping(value = "/paySms")
    public AppletResult paySms(@RequestBody ChinaPayBaseEntity chinaPayBaseEntity){
        return chinaPayService.paySms(chinaPayBaseEntity);
    }

    @SystemControllerLog(funcionExplain = "进入支付控制层")
    @PostMapping(value = "/pay")
    public AppletResult chinaPay(@RequestBody ChinaPayBaseEntity chinaPayBaseEntity){
        return chinaPayService.chinaPay(chinaPayBaseEntity);
    }

    @SystemControllerLog(funcionExplain = "银联单笔代付")
    @PostMapping(value = "/chinapaysinpay")
    public AppletResult chinaPay(@RequestBody ChinaPaySinPayReq chinaPaySinPayReq){
        return chinaPayService.chinaPaySinPay(chinaPaySinPayReq);
    }
}
