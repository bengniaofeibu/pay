package com.weichuxing.service.impl;

import com.weichuxing.entity.WcxRequest.BaseWcxRequest;
import com.weichuxing.entity.WcxRequest.UserInfoRequest;
import com.weichuxing.utils.common.Md5Util;

public class BaseServer {

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
