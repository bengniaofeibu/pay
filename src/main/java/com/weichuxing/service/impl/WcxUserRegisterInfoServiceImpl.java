package com.weichuxing.service.impl;

import com.weichuxing.annotation.SystemServerLog;
import com.weichuxing.mapper.WcxUserRegisterInfoMapper;
import com.weichuxing.entity.WcxRequest.WcxUserRegisterInfoRequest;
import com.weichuxing.service.WcxUserRegisterInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WcxUserRegisterInfoServiceImpl implements WcxUserRegisterInfoService {

    @Autowired
    private WcxUserRegisterInfoMapper wcxUserRegisterInfoMapper;

    private static final Logger LOGGER= LoggerFactory.getLogger(WcxUserRegisterInfoServiceImpl.class);

    /**
     * 操作微出行用户注册信息
     *
     * @param wcxUserRegisterInfo
     */
    @Override
    @SystemServerLog(funcionExplain = "操作微出行用户注册信息")
    public void notifyWcxUserRegisterInfo(WcxUserRegisterInfoRequest wcxUserRegisterInfo) {
        WcxUserRegisterInfoRequest wcxUserRegisterInfoRequest = wcxUserRegisterInfoMapper.selectWcxUserRegisterInfo(Long.valueOf(wcxUserRegisterInfo.getOpenId()));
        if (wcxUserRegisterInfoRequest==null){
            LOGGER.info("记录微出行注册用户信息");
            wcxUserRegisterInfoMapper.insertWcxUserRegisterInfo(wcxUserRegisterInfo);
        }else{
            LOGGER.info("更新微出行注册用户信息");
            wcxUserRegisterInfoMapper.updateByWcxUserId(wcxUserRegisterInfo);
        }
    }
}
