package com.applet.mapper;

import com.applet.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserInfoMapper {

    UserInfo selectUserInfoByUserId(String id);

    int updateUserAccountStatus(UserInfo userInfo);
}