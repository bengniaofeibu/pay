package com.weichuxing.service.impl;

import com.weichuxing.entity.WcxRequest.BaseWcxRequest;
import com.weichuxing.entity.WcxRequest.UserInfoRequest;
import com.weichuxing.mapper.TransRecordSupplyMapper;
import com.weichuxing.mapper.TransRecordTempMapper;
import com.weichuxing.mapper.UserInfoMapper;
import com.weichuxing.mapper.WcxUserRegisterInfoMapper;
import com.weichuxing.model.TransRecordSupply;
import com.weichuxing.utils.common.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseServer {

    @Autowired
    protected UserInfoMapper userInfoMapper;

    @Autowired
    protected WcxUserRegisterInfoMapper wcxUserRegisterInfoMapper;

    @Autowired
    protected TransRecordTempMapper transRecordTempMapper;

    @Autowired
    protected TransRecordSupplyMapper transRecordSupplyMapper;

    /**
     * 生成解密的key
     * key=取中间16位MD5(用财付通商户号+nonce_str)
     *
     * @param wcxRequest
     * @return
     */
    protected String getDecryptKey(BaseWcxRequest wcxRequest) {
        StringBuffer stringBuffer = new StringBuffer(wcxRequest.getSp_id() + wcxRequest.getNonce_str());
        return Md5Util.MD5(stringBuffer.toString()).substring(9, 25);
    }

}
