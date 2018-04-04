package com.applet.controller;

import com.applet.Base.BaseController;
import com.applet.annotation.SystemControllerLog;
import com.applet.model.CustomerAddressInfo;
import com.applet.service.CustomerInfoService;
import com.applet.utils.AppletResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cser")
public class CustomerController extends BaseController {

    //商户接口
    @Autowired
    private CustomerInfoService customerInfoService;


    /**
     * 获取客户地址{地址数据应该单独建一张表格，记录地址信息表中字段应该与用户id相关联}
     * @param userId
     * @return
     */
    @SystemControllerLog(funcionExplain = "进入获取客户地址控制层")
    @PostMapping(value = "/query/customerAddress")
    public AppletResult getCustomerAddress(String userId){

        return  customerInfoService.getCustomerAddress(userId);
    }


    /**
     * 添加修改地址列表
     * @param customerInfo
     * @return
     */
    @SystemControllerLog(funcionExplain = "进入添加修改地址控制层")
    @PostMapping(value = "/update/customerAddress")
    public AppletResult addAndUpdateAddress(@RequestBody CustomerAddressInfo customerInfo){

        return  customerInfoService.addAndUpdateAddress(customerInfo);
    }

    /**
     * 删除地址
     * @param id
     * @return
     */
    @SystemControllerLog(funcionExplain = "进入删除地址控制层")
    @PostMapping(value = "/modify/customerAddress")
    public AppletResult deleteAddress(Long id){

        return  customerInfoService.deleteAddress(id);
    }
}
