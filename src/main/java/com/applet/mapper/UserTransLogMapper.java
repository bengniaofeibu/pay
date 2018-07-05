package com.applet.mapper;

import com.applet.model.UserTransLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserTransLogMapper {

    int insertUserTransLog(UserTransLog record);

    int selectCountByOrderNo(@Param("userOrderNo") String userOrderNo);
}