package com.applet.mapper;

import com.applet.model.CustomerOrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface CustomerOrderInfoMapper {


    CustomerOrderInfo selectPayStatusByOrderNumber(Long orderNumber);

    int updateOrderStatusByOrderNum(CustomerOrderInfo record);
}