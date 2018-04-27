package com.applet.entity;

import com.applet.mapper.CustomerOrderInfoMapper;
import com.applet.model.BaseOrderInfo;
import com.applet.model.CustomerOrderInfo;
import com.applet.service.OrderStatusUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public  class PayBackStatusNotice {

    @Autowired
    private CustomerOrderInfoMapper customerOrderInfoMapper;


    /**
     * 判断订单状态是否已经支付成功
     * @param orderNumber
     * @return
     */
    public boolean isPayStatusSuccess(String orderNumber){

        // 查看商城订单状态是否已经更新成支付成功
        CustomerOrderInfo customerOrderInfo =queryOrderInfo(orderNumber);

        if (customerOrderInfo!=null){
            if (customerOrderInfo.getPayStatus().shortValue() == (short) 2) {
                return true;
            }
        }

        return false;
    }


    /**
     * 记录订单成功状态
     * @param baseOrderInfo
     */
    public void updatePaySuccessStatus(OrderStatusUpdateService orderStatusUpdateService, BaseOrderInfo baseOrderInfo){
            orderStatusUpdateService.updateOrderStatus(baseOrderInfo);
    }


    /**
     * 查询订单信息
     * @return
     */
    public CustomerOrderInfo queryOrderInfo(String orderNumber){
      return  customerOrderInfoMapper.selectPayStatusByOrderNumber(orderNumber);
    }
}
