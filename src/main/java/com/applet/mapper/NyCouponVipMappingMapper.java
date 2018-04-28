package com.applet.mapper;

import com.applet.model.NyCouponVipMapping;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface NyCouponVipMappingMapper {

    int updateCouponNumByUserIdAndCouponId(NyCouponVipMapping record);
}