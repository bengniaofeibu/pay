package com.applet.service;

import com.applet.model.BaseOrderInfo;

public interface OrderStatusUpdateService {

    /**
     * 更新订单状态
     */
    int updateOrderStatus(BaseOrderInfo baseOrderInfo);
}

