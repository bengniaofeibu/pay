package com.applet.controller;

import com.applet.Base.BaseController;
import com.applet.Request.UserPayReq;
import com.applet.annotation.SystemControllerLog;
import com.applet.enums.ResultEnums;
import com.applet.model.CustomerOrderInfo;
import com.applet.model.NyCoupon;
import com.applet.service.AliPayService;
import com.applet.service.WxPayService;
import com.applet.utils.AppletResult;
import com.applet.utils.ResultUtil;
import com.applet.utils.common.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
     * @param userPayReq
     * @return
     */
    @SystemControllerLog(funcionExplain = "进入支付控制层")
    @PostMapping("/userpay")
    public AppletResult userPay(@RequestBody UserPayReq userPayReq){

        CustomerOrderInfo customerOrderInfo = getCustomerOrderInfo(userPayReq.getOrderNumber());

        if (customerOrderInfo !=null ){

            NyCoupon nyCoupon;
            BigDecimal amount;
            if (userPayReq.getCouponId()!= null){

                 nyCoupon = nyCouponMapper.selectPayAmountByCouponId(userPayReq.getCouponId());

                 if (nyCoupon != null ){

                     //添加用户优惠劵金额缓存
                     addUserCouponAmoutCache(userPayReq.getUserId(),nyCoupon);

                     amount = calculatePayAmount(customerOrderInfo.getPayAmount(),new BigDecimal(nyCoupon.getNyCouponType().getParValue() / 100));
                     LOGGER.debug("优惠劵金额 --> {}  实际支付金额 --> {}",nyCoupon.getNyCouponType().getParValue(),amount);

                 }else {
                     amount=customerOrderInfo.getPayAmount();
                 }
            }else {
                amount=customerOrderInfo.getPayAmount();
            }

            //判断金额是否小于等于0
            if ( amount.doubleValue() <= 0.00 ){
              return  ResultUtil.error(ResultEnums.PAY_AMOUNT_EXCEPTION_FAIL);
            }

            userPayReq.setPayAmount(amount);
            return userPayReq.getPayWay().intValue()==0?aliPayService.pay(userPayReq):wxPayService.pay(userPayReq);
        }
      return ResultUtil.error(ResultEnums.NOT_FOUNT_ORDERNUM_FAIL);
    }
}
