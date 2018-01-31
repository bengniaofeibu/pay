package com.weichuxing.service.impl;

import com.weichuxing.entity.WcxRequest.BaseWcxRequest;
import com.weichuxing.entity.WcxRequest.UserInfoRequest;
import com.weichuxing.mapper.*;
import com.weichuxing.model.TransRecordInfo;
import com.weichuxing.model.TransRecordSupply;
import com.weichuxing.utils.WcxServiceUtil;
import com.weichuxing.utils.common.Md5Util;
import com.weichuxing.utils.common.RSAUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;

public class BaseServer {

    @Autowired
    protected UserInfoMapper userInfoMapper;

    @Autowired
    protected WcxUserRegisterInfoMapper wcxUserRegisterInfoMapper;

    @Autowired
    protected TransRecordTempMapper transRecordTempMapper;

    @Autowired
    protected TransRecordSupplyMapper transRecordSupplyMapper;

    @Autowired
    protected WcxFenceInfoMapper wcxFenceInfoMapper;

    @Autowired
    protected TransRecordInfoMapper transRecordInfoMapper;

    @Autowired
    protected WcxServiceUtil wcxServiceUtil;
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


    /**
     * 生成退押金的订单id
     * @param rangeNum
     * @return
     */
    protected   String generateDepositNum(int rangeNum){
        Integer num = new Random().nextInt(rangeNum) + 1;
        String str = num.toString();
        while (str.length() < 3) {

            str = "0" + str;
        }
        StringBuffer stringBuffer=new StringBuffer();
        return System.currentTimeMillis()+str;
    }

    /**
     * RSA私钥加密
     * @param data
     * @param key
     * @return
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     */
    public  String rsaEncrypt(String data,String key) throws InvalidKeySpecException, NoSuchAlgorithmException {
        RSAPrivateKey privateKey=  RSAUtils.getPrivateKey(key);
      return   RSAUtils.privateEncrypt(data,privateKey);
    }
}
