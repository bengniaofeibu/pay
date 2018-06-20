package com.applet.mapper;

import com.applet.model.UserBankcardInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserBankcardInfoMapper {

    int insertSelective(UserBankcardInfo record);

    String selectUserCardNoByUserId(@Param("userId") String userId);

    int updateByPrimaryKeySelective(UserBankcardInfo record);

}