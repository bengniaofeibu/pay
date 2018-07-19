package com.applet.controller;

import com.applet.Base.BaseController;
import com.applet.Request.UserPayReq;
import com.applet.annotation.SystemControllerLog;
import com.applet.entity.ChinaPayBaseEntity;
import com.applet.enums.ResultEnums;
import com.applet.model.CustomerOrderInfo;
import com.applet.utils.AppletResult;
import com.applet.utils.ResultUtil;
import com.applet.utils.common.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/pay")
public class PayController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayController.class);

    /**
     * 用户支付
     *
     * @param userPayReq
     * @return
     */
    @SystemControllerLog(funcionExplain = "进入支付控制层")
    @PostMapping("/userpay")
    public AppletResult userPay(@RequestBody UserPayReq userPayReq) {

        CustomerOrderInfo customerOrderInfo = getCustomerOrderInfo(userPayReq.getOrderNumber());

        if (customerOrderInfo != null) {
            return getUserPayResult(userPayReq,customerOrderInfo);
        }
        return customerOrderInfo != null?ResultUtil.error(ResultEnums.NOT_FOUNT_ORDERNUM_FAIL): getUserPayResult(userPayReq,customerOrderInfo);
    }



    /**
     * 用户罚款支付
     *
     * @param userPayReq
     * @return
     */
    @SystemControllerLog(funcionExplain = "进入用户罚款支付支付控制层")
    @PostMapping(value = "/userfinepay")
    public AppletResult userFinePay(@RequestBody UserPayReq userPayReq){
        return finePayResult(userPayReq);
    }


   @SystemControllerLog(funcionExplain = "进入银联支付控制层")
   @PostMapping(value = "/chinapay")
   public AppletResult chinaPay(@RequestBody UserPayReq userPayReq){
       LOGGER.debug("银联支付参数 {}",JSONUtil.toJSONString(userPayReq));


       BigDecimal amount = getUserPayAmoutCache(userPayReq.getOrderNumber());
       LOGGER.debug("银联时间支付金额 {}",amount);

       if (amount != null){

           //判断金额是否小于等于0
           if (amount.doubleValue() <= 0.00) {
               return ResultUtil.error(ResultEnums.PAY_AMOUNT_EXCEPTION_FAIL);
           }

           userPayReq.setPayAmount(amount);
           ChinaPayBaseEntity chinaPayBaseEntity=getChinaPayBaseEntity(userPayReq);

           if (chinaPayBaseEntity == null){
               return ResultUtil.error(ResultEnums.CHINA_PAY_FAIL);
           }

           return chinaPayService.chinaPay(chinaPayBaseEntity);
       }
       return ResultUtil.error(ResultEnums.CHINA_PAY_FAIL);
   }

   @SystemControllerLog(funcionExplain = "进入微信企业转账到个人控制层")
   @PostMapping(value = "/wxTransfer")
   public AppletResult wxTransfer(@RequestBody UserPayReq userPayReq){
       return wxPayService.wxTransfer(userPayReq);
   }
}
