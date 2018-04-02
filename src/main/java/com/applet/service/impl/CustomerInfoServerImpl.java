package com.applet.service.impl;

import com.applet.annotation.SystemServerLog;
import com.applet.entity.CustomerInfo;
import com.applet.service.CustomerInfoService;
import com.applet.utils.AppletResult;
import com.applet.utils.ResultUtil;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CustomerInfoServerImpl implements CustomerInfoService {
    /**
     * 获取客户地址
     *
     * @param userId
     * @return
     */
    @SystemServerLog(funcionExplain = "获取客户地址")
    @Override
    public AppletResult getCustomerAddress(String userId) {
        List<CustomerInfo> list=new LinkedList<>();

        list.add(new CustomerInfo("上海","上海市","闵行区","金汇路金汇四季广场"));
        list.add(new CustomerInfo("上海","上海市","浦东新区","盛夏路570号"));

        return ResultUtil.success(list);
    }
}
