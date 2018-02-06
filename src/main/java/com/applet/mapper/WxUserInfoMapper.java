package com.applet.mapper;

import com.applet.model.WxUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface WxUserInfoMapper {

    int insertSelective(WxUserInfo record);

    WxUserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WxUserInfo record);

}