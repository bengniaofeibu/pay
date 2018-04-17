package com.applet.service;

import com.applet.Base.BaseModel;
import com.applet.model.CustomerOrderInfo;

public interface OrderStatusUpdateService {

    /**
     * 更新订单状态
     */
    int updateOrderStatus(CustomerOrderInfo customerOrderInfo);
}
