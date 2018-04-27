package com.applet.Base;

import com.applet.entity.PayBackStatusNotice;
import com.applet.mapper.NyCouponMapper;
import com.applet.model.CustomerOrderInfo;
import com.applet.service.AliPayService;
import com.applet.service.WxPayService;
import com.applet.utils.common.BigDecimalUtil;
import com.applet.utils.common.JSONUtil;
import com.applet.utils.common.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public abstract class BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);


    private static final String COUPON_AMOUNT_KEY="user:pay:coupon:";

    //微信支付服务
    @Autowired
    protected WxPayService wxPayService;

    //支付宝支付
    @Autowired
    protected AliPayService aliPayService;


    @Autowired
    protected NyCouponMapper nyCouponMapper;

    @Autowired
    protected PayBackStatusNotice payBackStatusNotice;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 计算最后支付金额
     * @param stayAmout 待支付金额
     * @param couponAmout 优惠金额
     * @return
     */
    public static BigDecimal calculatePayAmount(BigDecimal stayAmout, BigDecimal couponAmout){
        return BigDecimalUtil.subtract(stayAmout,couponAmout);
    }

    /**
     * 查询订单详情
     * @param orderNumber
     * @return
     */
    protected  CustomerOrderInfo getCustomerOrderInfo(String orderNumber){
        CustomerOrderInfo customerOrderInfo = payBackStatusNotice.queryOrderInfo(orderNumber);
        LOGGER.debug(" 订单详情 --> {}", JSONUtil.toJSONString(customerOrderInfo));
        return customerOrderInfo;
    }

    /**
     * 添加用户优惠劵金额缓存
     * @param userId
     * @param couponAmout
     */
    protected void addUserCouponAmoutCache(String userId,long couponAmout){
       String couponAmountKey =new StringBuilder(COUPON_AMOUNT_KEY).append(userId).toString();
        redisUtil.setObj(couponAmountKey,couponAmout);
    }
}
