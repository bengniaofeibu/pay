package com.applet.mapper;

import com.applet.model.NyCouponType;

public interface NyCouponTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(NyCouponType record);

    int insertSelective(NyCouponType record);

    NyCouponType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(NyCouponType record);

    int updateByPrimaryKey(NyCouponType record);
}