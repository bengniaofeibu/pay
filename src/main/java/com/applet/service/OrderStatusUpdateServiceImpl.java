package com.applet.service;

import com.applet.Base.BaseModel;
import com.applet.annotation.SystemServerLog;
import com.applet.mapper.CustomerOrderInfoMapper;
import com.applet.model.CustomerOrderInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OrderStatusUpdateServiceImpl implements OrderStatusUpdateService {

    private static final Logger LOGGER= LoggerFactory.getLogger(OrderStatusUpdateServiceImpl.class);


    @Autowired
    private CustomerOrderInfoMapper customerOrderInfoMapper;

    /**
     * 更新订单状态
     *
     * @param customerOrderInfo
     */
    @SystemServerLog(funcionExplain = "更新订单状态服务")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateOrderStatus(CustomerOrderInfo customerOrderInfo) {
        int updateCount = customerOrderInfoMapper.updateOrderStatusByOrderNum(customerOrderInfo);
        LOGGER.debug("更新用户状态数量 --> {}",updateCount);
        return updateCount;
    }
}
