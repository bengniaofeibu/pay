package com.applet.Base;

import com.applet.Request.UserPayReq;
import com.applet.entity.ChinaPayBaseEntity;
import com.applet.entity.PayBackStatusNotice;
import com.applet.enums.ResultEnums;
import com.applet.mapper.NoparkFineDetailMapper;
import com.applet.mapper.NyCouponMapper;
import com.applet.mapper.UserBankcardInfoMapper;
import com.applet.model.CustomerOrderInfo;
import com.applet.model.NoparkFineDetail;
import com.applet.model.NyCoupon;
import com.applet.service.AliPayService;
import com.applet.service.ChinaPayService;
import com.applet.service.WxPayService;
import com.applet.utils.AppletResult;
import com.applet.utils.ResultUtil;
import com.applet.utils.common.BigDecimalUtil;
import com.applet.utils.common.JSONUtil;
import com.applet.utils.common.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public abstract class BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);


    private static final String COUPON_AMOUNT_KEY = "user:pay:coupon:";

    private static final String USER_PAY_AMOUNT_KEY = "user:pay:amount:";

    //微信支付服务
    @Autowired
    protected WxPayService wxPayService;

    //支付宝支付
    @Autowired
    protected AliPayService aliPayService;

    @Autowired
    protected ChinaPayService chinaPayService;


    @Autowired
    protected NyCouponMapper nyCouponMapper;

    @Autowired
    protected UserBankcardInfoMapper userBankcardInfoMapper;

    @Autowired
    protected PayBackStatusNotice payBackStatusNotice;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private NoparkFineDetailMapper noparkFineDetailMapper;

    /**
     * 计算最后支付金额
     *
     * @param stayAmout   待支付金额
     * @param couponAmout 优惠金额
     * @return
     */
    public static BigDecimal calculatePayAmount(BigDecimal stayAmout, BigDecimal couponAmout) {
        return BigDecimalUtil.subtract(stayAmout, couponAmout);
    }

    /**
     * 查询订单详情
     *
     * @param orderNumber
     * @return
     */
    protected CustomerOrderInfo getCustomerOrderInfo(String orderNumber) {
        CustomerOrderInfo customerOrderInfo = payBackStatusNotice.queryOrderInfo(orderNumber);
        LOGGER.debug(" 订单详情 --> {}", JSONUtil.toJSONString(customerOrderInfo));
        return customerOrderInfo;
    }

    /**
     * 添加用户优惠劵金额缓存
     *
     * @param userId
     * @param nyCoupon
     */
    protected void addUserCouponAmoutCache(String userId, NyCoupon nyCoupon) {
        String couponAmountKey = new StringBuilder(COUPON_AMOUNT_KEY).append(userId).toString();
        redisUtil.setObjAndExpire(couponAmountKey, nyCoupon, 3600);
    }

    /**
     * 添加用户缓存
     *
     * @param orderNumber
     * @param amout
     */
    protected void addUserPayAmoutCache(String orderNumber, String amout) {
        String couponAmountKey = new StringBuilder(USER_PAY_AMOUNT_KEY).append(orderNumber).toString();
        redisUtil.setObjAndExpire(couponAmountKey, amout, 3600);
    }

    /**
     * 获取缓存用户金额
     *
     * @param orderNumber
     */
    protected BigDecimal getUserPayAmoutCache(String orderNumber) {
        String cacheAmount = (String)redisUtil.getValueObj(new StringBuilder(USER_PAY_AMOUNT_KEY).append(orderNumber).toString());
        return new BigDecimal(cacheAmount);
    }


    /**
     * 用户罚款支付
     * @param userPayReq
     * @return
     */
    protected AppletResult finePayResult(UserPayReq userPayReq){

      NoparkFineDetail noparkFineDetail = noparkFineDetailMapper.selectRechargeIdByUserIdAndStatus(userPayReq.getUserId());
       LOGGER.debug("用户罚款订单信息 {}",JSONUtil.toJSONString(noparkFineDetail));

       if (noparkFineDetail == null){
           return ResultUtil.error(ResultEnums.NOT_FOUNT_ORDERNUM_FAIL);
       }

        AppletResult result = null;
//        userPayReq.setPayAmount(new BigDecimal(noparkFineDetail.getFineMoney()).divide(new BigDecimal(100)));
        userPayReq.setPayAmount(new BigDecimal(0.1).setScale(2, BigDecimal.ROUND_HALF_UP));
        userPayReq.setOrderNumber(noparkFineDetail.getRechargeId());
        switch (userPayReq.getPayWay()){
            case 0:
                //支付宝
                result = aliPayService.pay(userPayReq);
                break;
            case 1:
                //微信
                result = wxPayService.pay(userPayReq);
                break;
        }
        return result;
    }


    protected AppletResult getUserPayResult(UserPayReq userPayReq, CustomerOrderInfo customerOrderInfo) {

        BigDecimal amount = calculateUserPayAmount(userPayReq, customerOrderInfo);
        LOGGER.debug("用户实际支金额");

        AppletResult result = null;
        userPayReq.setPayAmount(amount);
        switch (userPayReq.getPayWay()) {
            case 0:
                //支付宝
                result = aliPayService.pay(userPayReq);
                break;
            case 1:
                //微信
                result = wxPayService.pay(userPayReq);
                break;
            case 2:
                userPayReq.setPayAmount(new BigDecimal(1000));
                //银联支付短信
                ChinaPayBaseEntity chinaPayBaseEntity = getChinaPayBaseEntity(userPayReq);

                if (chinaPayBaseEntity == null) {
                    return ResultUtil.error(ResultEnums.CHINA_PAY_SMS_FAIL);
                }

                result = chinaPayService.paySms(chinaPayBaseEntity);

                if (result.getCode() == 200 ){
                    //添加用户时间支付金额到缓存，给银联支付时使用
                    addUserPayAmoutCache(userPayReq.getOrderNumber(), userPayReq.getPayAmount().toString());
                }
                break;
        }
        return result;
    }


    /**
     * 计算用户实际支付金额
     *
     * @param userPayReq
     * @return
     */
    protected BigDecimal calculateUserPayAmount(UserPayReq userPayReq, CustomerOrderInfo customerOrderInfo) {

        BigDecimal amount = null;
        switch (userPayReq.getCouponFlag()) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                NyCoupon nyCoupon = nyCouponMapper.selectPayAmountByCouponId(userPayReq.getCouponId());
                if (nyCoupon != null) {

                    //添加用户优惠劵金额缓存
                    addUserCouponAmoutCache(userPayReq.getUserId(), nyCoupon);

                    amount = calculatePayAmount(customerOrderInfo.getPayAmount(), new BigDecimal(nyCoupon.getNyCouponType().getParValue() / 100));
                    LOGGER.debug("优惠劵金额 --> {}  实际支付金额 --> {}", nyCoupon.getNyCouponType().getParValue(), amount);
                }
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                return customerOrderInfo.getPayAmount().divide(new BigDecimal(100));
        }

        return amount;
    }


    protected ChinaPayBaseEntity getChinaPayBaseEntity(UserPayReq userPayReq) {
        ChinaPayBaseEntity chinaPayBaseEntity = new ChinaPayBaseEntity.Builder().setMerOrderNo(userPayReq.getOrderNumber())
                .setOrderAmt(userPayReq.getPayAmount().toString()).setCardNo(userPayReq.getCardNo()).setMobileAuthCode(userPayReq.getMobileAuthCode())
                .setAmounts(new String[]{userPayReq.getPayAmount().toString()}).build();
        return chinaPayBaseEntity;
    }

}
