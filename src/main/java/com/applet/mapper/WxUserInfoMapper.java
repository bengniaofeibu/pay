package com.applet.mapper;

import com.applet.model.WxUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface WxUserInfoMapper {

    int insertSelective(WxUserInfo record);

    String selectUserIdByOpenId(String openId);

    int updateUserStatusById(WxUserInfo record);

    Integer selectNumByOpenId(String openId);



}