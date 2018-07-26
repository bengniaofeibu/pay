package com.applet.mapper;

import com.applet.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserInfoMapper {

    UserInfo selectUserInfoByUserId(String id);

    int updateUserAccountStatus(UserInfo userInfo);

    int  updateUserCreditScore(String userId);

    int updateUserPenaltyStatus(@Param("id") String id);
}