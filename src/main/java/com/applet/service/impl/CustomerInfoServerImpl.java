package com.applet.service.impl;

import com.applet.annotation.SystemServerLog;
import com.applet.enums.ResultEnums;
import com.applet.mapper.CustomerAddressInfoMapper;
import com.applet.model.CustomerAddressInfo;
import com.applet.service.CustomerInfoService;
import com.applet.utils.AppletResult;
import com.applet.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CustomerInfoServerImpl implements CustomerInfoService {


     private static final Logger LOGGER= LoggerFactory.getLogger(CustomerInfoServerImpl.class);

     @Autowired
     private CustomerAddressInfoMapper customerAddressInfoMapper;

    /**
     * 获取客户地址
     *
     * @param userId
     * @return
     */
    @SystemServerLog(funcionExplain = "获取客户地址")
    @Override
    public AppletResult getCustomerAddress(String userId) {

        return ResultUtil.success(ResultEnums.RETURN_SUCCESS,customerAddressInfoMapper.selectByUserId(userId));
    }

    /**
     * 添加及修改用户地址
     *
     * @param customerInfo
     * @return
     */
    @SystemServerLog(funcionExplain = "添加或者修改客户地址")
    @Override
    public AppletResult addAndUpdateAddress(CustomerAddressInfo customerInfo) {
        if(StringUtils.isEmpty(customerInfo.getId())){
            customerAddressInfoMapper.insertCustomerAddressInfo(customerInfo);
            return ResultUtil.success();
        }else {
            customerAddressInfoMapper.updateCustomerAddressInfo(customerInfo);
            return ResultUtil.success();
        }
    }

    /**
     * 删除用户地址
     *
     * @param id
     * @return
     */
    @SystemServerLog(funcionExplain = "删除客户地址")
    @Override
    public AppletResult deleteAddress(Long id) {
        customerAddressInfoMapper.updateDelFlag(id);
        return ResultUtil.success();
    }
}
