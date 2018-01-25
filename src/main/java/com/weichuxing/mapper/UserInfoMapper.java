package com.weichuxing.mapper;

import com.weichuxing.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserInfoMapper {

    /**
     * 根据手机号查询用户信息
     * @param phone
     * @return
     */
    UserInfo selectByUserPhone(String phone);

    /**
     * 查询用户是否存在
     * @param id
     * @return
     */
    Long selectWcxUserCount(Long id);

    /**
     * 记录微出行注册用户
     * @param userInfo
     */
    void insertUserInfo(UserInfo userInfo);


    /**
     * 更新用户状态
     * @param userInfo
     */
    void updateUserInfoById(UserInfo userInfo);
}