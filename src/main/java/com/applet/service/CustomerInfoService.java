package com.applet.service;

import com.applet.model.CustomerAddressInfo;
import com.applet.utils.AppletResult;

public interface CustomerInfoService {

    /**
     * 获取客户地址
     * @param userId
     * @return
     */
    AppletResult getCustomerAddress(String userId);


    /**
     * 添加及修改地址
     * @param customerInfo
     * @return
     */
    AppletResult addAndUpdateAddress(CustomerAddressInfo customerInfo);

    /**
     * 删除地址
     * @param id
     * @return
     */
    AppletResult deleteAddress(Long id);
}
