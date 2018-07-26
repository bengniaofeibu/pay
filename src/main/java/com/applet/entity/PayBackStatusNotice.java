package com.applet.entity;

import com.applet.Base.BaseServiceImpl;
import com.applet.mapper.CustomerOrderInfoMapper;
import com.applet.mapper.NoparkFineDetailMapper;
import com.applet.model.BaseOrderInfo;
import com.applet.model.CustomerOrderInfo;
import com.applet.service.FineOrderUpdateService;
import com.applet.service.OrderStatusUpdateService;
import com.applet.service.StoreOrderUpdateService;
import com.applet.service.impl.FineOrderUpdateServiceImpl;
import com.applet.utils.common.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Component
public class PayBackStatusNotice {


    private static final Logger LOGGER = LoggerFactory.getLogger(PayBackStatusNotice.class);

    @Autowired
    private CustomerOrderInfoMapper customerOrderInfoMapper;

    //商城支付
    @Resource(name = "storeOrderUpdateService")
    private StoreOrderUpdateService storeOrderUpdateService;


    @Resource(name = "fineOrderUpdateService")
    private FineOrderUpdateService fineOrderUpdateService;


    @Autowired
    private NoparkFineDetailMapper noparkFineDetailMapper;

    @Autowired
    private RedisUtil redisUtil;

    private static final String MALL_PAY = "商城支付";

    private static final String AMERCEMENT_OUTLAY = "罚款支付";


    /**
     * 判断订单状态是否已经支付成功
     *
     * @param orderNumber
     * @return
     */
    public boolean isPayStatusSuccess(String orderNumber) {

        String orderSubjectKey = new StringBuilder(BaseServiceImpl.USER_PAY_SUBJECT).append(orderNumber).toString();

        Object orderSubject = redisUtil.getValueObj(orderSubjectKey);
        LOGGER.debug("订单号 {} 订单标题 {} ", orderNumber, orderSubject);

        if (orderSubject == null) return true;

        switch (orderSubject.toString()) {
            case MALL_PAY:
                // 查看商城订单状态是否已经更新成支付成功
                CustomerOrderInfo customerOrderInfo = queryOrderInfo(orderNumber);

                if (customerOrderInfo != null) {
                    if (customerOrderInfo.getPayStatus().shortValue() == (short) 2) {
                        return true;
                    }
                }
                break;
            case AMERCEMENT_OUTLAY:
                //查看用户是否成功缴纳押金
                int count = noparkFineDetailMapper.selectPaySuccessCountByRechargeId(orderNumber);
                if (count > 0) {
                    return true;
                }
                break;
        }


        return false;
    }


    /**
     * 记录订单成功状态
     *
     * @param baseOrderInfo
     */
    public void updatePaySuccessStatus(OrderStatusUpdateService orderStatusUpdateService, BaseOrderInfo baseOrderInfo) {
        orderStatusUpdateService.updateOrderStatus(baseOrderInfo);
    }


    /**
     * 查询订单信息
     *
     * @return
     */
    public CustomerOrderInfo queryOrderInfo(String orderNumber) {
        return customerOrderInfoMapper.selectPayStatusByOrderNumber(orderNumber);
    }


    /**
     * 根据订单号获取支付标题
     *
     * @param orderNumber
     * @return
     */
    public OrderStatusUpdateService getUpdateOrderStatusService(String orderNumber) {

        String orderSubjectKey = new StringBuilder(BaseServiceImpl.USER_PAY_SUBJECT).append(orderNumber).toString();

        Object orderSubject = redisUtil.getValueObj(orderSubjectKey);
        LOGGER.debug("订单号 {} 订单标题 {} ", orderNumber, orderSubject);

        OrderStatusUpdateService orderStatusUpdateService = null;
        switch (orderSubject.toString()) {
            case MALL_PAY:
                orderStatusUpdateService = storeOrderUpdateService;
                break;
            case AMERCEMENT_OUTLAY:
                orderStatusUpdateService = fineOrderUpdateService;
                break;
        }
        //删除订单标题缓存
        redisUtil.deteleKey(orderSubjectKey);
        return orderStatusUpdateService;
    }
}
