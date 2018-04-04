package com.applet.mapper;

import com.applet.model.CustomerAddressInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper
public interface CustomerAddressInfoMapper {

    int insertCustomerAddressInfo(CustomerAddressInfo record);

    List<CustomerAddressInfo> selectByUserId(String userId);

    int updateCustomerAddressInfo(CustomerAddressInfo record);

    int updateDelFlag(Long id);
}