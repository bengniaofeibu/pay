package com.weichuxing.mapper;

import com.weichuxing.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
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

}