package com.weichuxing.mapper;


import com.weichuxing.entity.WcxRequest.WcxUserRegisterInfoRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface WcxUserRegisterInfoMapper {


    int insertWcxUserInfo(WcxUserRegisterInfoRequest record);

    Long selectWcxUserCount(Long openid);

    int updateUserInfoById(WcxUserRegisterInfoRequest record);
}