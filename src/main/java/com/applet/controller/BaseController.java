package com.applet.controller;


import com.applet.entity.Cat;
import com.applet.entity.BaseEntity.BaseRequestEntity;
import com.applet.enums.ResultEnums;
import com.applet.mapper.WxUserInfoMapper;
import com.applet.service.RidingService;
import com.applet.service.ScavengingUnlockService;
import com.applet.utils.AppletResult;
import com.applet.utils.ResultUtil;
import com.applet.utils.common.EncrypUtil;
import com.applet.utils.common.JSONUtil;
import com.applet.utils.common.RedisUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Map;

public class BaseController {



    @Autowired
    protected RedisUtil redisUtil;

    @Autowired
    private WxUserInfoMapper wxUserInfoMapper;

    @Autowired
    protected RidingService ridingService;

    @Autowired
    protected ScavengingUnlockService scavengingUnlockService;

    /**
     * 验证请求参数
     * @return
     */
    protected AppletResult validateReqParam(BaseRequestEntity request){
        Map<String,Object> map = JSONUtil.parseObject(JSONUtil.toJSONString(request), Map.class);
        for (Map.Entry<String,Object> entry:map.entrySet()) {
           if (entry.getValue()==null || "".equals(entry.getValue()) ){
                return ResultUtil.error(ResultEnums.PARAM_IS_NULL,new String[]{entry.getKey()});
           }
        }
        return null;
    }

    /**
     * 获取授权信息
     * @param session
     * @return
     */
    protected Cat getAuthInfo(String session){
     Object obj = redisUtil.getValueObj(session);
      return JSONUtil.parseObject(JSONUtil.toJSONString(obj),Cat.class);
    }


    /**
     * 解密小程序返回的数据并封装成实体
     * @param encryptedData
     * @param sessionKey
     * @param iv
     * @param tClass
     * @param <T>
     * @return
     * @throws InvalidAlgorithmParameterException
     * @throws UnsupportedEncodingException
     */
    protected  <T> T encryptedDataToObject(String encryptedData,String sessionKey,String iv,Class<T> tClass) throws InvalidAlgorithmParameterException, UnsupportedEncodingException {
        byte[] resultByte = EncrypUtil.decrypt(Base64.decodeBase64(encryptedData), Base64.decodeBase64(sessionKey), Base64.decodeBase64(iv));
        if (null != resultByte && resultByte.length > 0) {
            String userInfo = new String(resultByte, "UTF-8");
            return JSONUtil.parseObject(userInfo, tClass);
        }
           return null;
    }


    /**
     * 判断用法是否存在
     * @param openId
     * @return
     */
    protected AppletResult isUserRegistered(String openId){
        Integer count = wxUserInfoMapper.selectNumByOpenId(openId);
        if (count>0){
            return ResultUtil.error(ResultEnums.USER_ALREADY_EXIST);
        }
        return null;
    }
}
