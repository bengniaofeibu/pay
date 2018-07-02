package com.applet.mapper;

import com.applet.model.CustomerOrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface CustomerOrderInfoMapper {


    CustomerOrderInfo selectPayStatusByOrderNumber(@Param("orderNumber") String orderNumber);

    int updateOrderStatusByOrderNum(CustomerOrderInfo record);
}