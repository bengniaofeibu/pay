package com.applet.mapper;

import com.applet.model.NyCoupon;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface NyCouponMapper {

    Long selectPayAmountByCouponId(String id);
}