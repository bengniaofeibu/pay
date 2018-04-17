package com.applet.entity;

import com.applet.mapper.CustomerOrderInfoMapper;
import com.applet.model.BaseOrderInfo;
import com.applet.model.CustomerOrderInfo;
import com.applet.service.OrderStatusUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public  class PayBackStatusNotice {

    @Autowired
    private CustomerOrderInfoMapper customerOrderInfoMapper;

    @Autowired
    private OrderStatusUpdateService orderStatusUpdateService;


    /**
     * 判断订单状态是否已经支付成功
     * @param orderNumber
     * @return
     */
    public boolean isPayStatusSuccess(Long orderNumber){

        // 查看商城订单状态是否已经更新成支付成功
        CustomerOrderInfo customerOrderInfo = customerOrderInfoMapper.selectPayStatusByOrderNumber(
                orderNumber);

        if (customerOrderInfo!=null){
            if (customerOrderInfo.getPayStatus().shortValue() == (short) 1) {
                return true;
            }
        }

        return false;
    }


    /**
     * 记录订单成功状态
     * @param baseOrderInfo
     */
    public void updatePaySuccessStatus(BaseOrderInfo baseOrderInfo){

        CustomerOrderInfo customerOrderInfo = customerOrderInfoMapper.selectPayStatusByOrderNumber(
                Long.parseLong(baseOrderInfo.getOrderNumber()));
        if (customerOrderInfo!=null){
            // 商城充值成功
            CustomerOrderInfo orInfo = new CustomerOrderInfo();
            orInfo.setOrderNumber(baseOrderInfo.getOrderNumber());
            orInfo.setTradeNo(baseOrderInfo.getTradeNo());
            orInfo.setUserPayNumber(baseOrderInfo.getUserPayNumber());
            orInfo.setPayStatus((short) 2);
            orderStatusUpdateService.updateOrderStatus(orInfo);
        }
    }
}
