package com.weichuxing.mapper;

import com.weichuxing.entity.WcxRequest.WcxUserRegisterInfoRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface WcxUserRegisterInfoMapper {

    int insertWcxUserRegisterInfo(WcxUserRegisterInfoRequest record);

    WcxUserRegisterInfoRequest selectWcxUserRegisterInfo(Long id);

    int updateByWcxUserId(WcxUserRegisterInfoRequest record);
}