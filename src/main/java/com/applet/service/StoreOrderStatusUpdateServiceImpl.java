package com.applet.service;

import com.applet.annotation.SystemServerLog;
import com.applet.mapper.CustomerOrderInfoMapper;
import com.applet.mapper.NyCouponVipMappingMapper;
import com.applet.mapper.NyGoodsSkuMapper;
import com.applet.model.BaseOrderInfo;
import com.applet.model.CustomerOrderInfo;
import com.applet.model.NyCoupon;
import com.applet.model.NyCouponVipMapping;
import com.applet.utils.common.JSONUtil;
import com.applet.utils.common.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


@Service("storeOrderUpdateService")
public class StoreOrderStatusUpdateServiceImpl implements StoreOrderUpdateService {

    private static final Logger LOGGER= LoggerFactory.getLogger(StoreOrderStatusUpdateServiceImpl.class);


    protected static final String NOT_PAY_TIME_KEY="pay:not:time:";

    private static final String COUPON_AMOUNT_KEY="user:pay:coupon:";


    @Autowired
    private CustomerOrderInfoMapper customerOrderInfoMapper;


    @Autowired
    private NyGoodsSkuMapper nyGoodsSkuMapper;

    @Autowired
    private NyCouponVipMappingMapper nyCouponVipMappingMapper;


    @Autowired
    private RedisUtil redisUtil;

    /**
     * 更新订单状态
     *
     * @param baseOrderInfo
     */
    @SystemServerLog(funcionExplain = "更新订单状态服务")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateOrderStatus(BaseOrderInfo baseOrderInfo) {

         try {
             CustomerOrderInfo customerOrderInfo = customerOrderInfoMapper.selectPayStatusByOrderNumber(
                     baseOrderInfo.getOrderNumber());
             if (customerOrderInfo!=null) {
                 // 更新用户订单充值成功

                 String couponAmountKey=new StringBuilder(COUPON_AMOUNT_KEY).append(customerOrderInfo.getOrderNumber()).toString();


                 Object obj = redisUtil.getValueObj(couponAmountKey);
                 if (obj != null){
                     NyCoupon nyCoupon= JSONUtil.parseObject(JSONUtil.toJSONString(obj),NyCoupon.class);
                     LOGGER.debug("缓存中的优惠劵信息 --> {}",nyCoupon);
                     customerOrderInfo.setDiscountAmount(new BigDecimal(nyCoupon.getNyCouponType().getParValue()/100));

                     NyCouponVipMapping nyCouponVipMapping=new NyCouponVipMapping(customerOrderInfo.getUserId(),nyCoupon.getId());
                     int updateCount = nyCouponVipMappingMapper.updateCouponNumByUserIdAndCouponId(nyCouponVipMapping);
                     LOGGER.debug("更新用户优惠劵已使用 --> {}",updateCount);

                     //删除用户优惠劵金额缓存
                     redisUtil.deteleKey(couponAmountKey);
                 }

                 customerOrderInfo.setOrderNumber(baseOrderInfo.getOrderNumber());
                 customerOrderInfo.setTotalAmount(baseOrderInfo.getTotalAmount());
                 customerOrderInfo.setTradeNo(baseOrderInfo.getTradeNo());
                 customerOrderInfo.setUserPayNumber(baseOrderInfo.getUserPayNumber());
                 customerOrderInfo.setPayStatus((short) 2);
                 customerOrderInfo.setPayWay(baseOrderInfo.getPayWay());
                 int updateCount = customerOrderInfoMapper.updateOrderStatusByOrderNum(customerOrderInfo);
                 LOGGER.debug("更新用户状态数量 --> {}", updateCount);


//                 int updateGoodsCount = nyGoodsSkuMapper.updateGoodsNumByGoods(customerOrderInfo.getOrderGoodsId());
//                 LOGGER.debug("更新商品库存数量 --> {}", updateGoodsCount);

                 //删除缓存剩余支付时间
                 redisUtil.deleteObject(NOT_PAY_TIME_KEY, baseOrderInfo.getOrderNumber());

                 return updateCount;
             }
         }catch (Exception e){
               LOGGER.error(" system error --> {}",e);
         }
        return 0;
    }
}
