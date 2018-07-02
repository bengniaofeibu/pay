package com.applet.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface BicycleWxUserInfoMapper {

    /**
     * 根据用户id查询openId
     * @param userId
     * @return
     */
    String selectOpenIdByUserId(@Param("userId") String userId);
}