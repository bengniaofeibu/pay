package com.weichuxing.controller;

import com.weichuxing.entity.WcxRequest.BaseWcxRequest;
import com.weichuxing.service.UserInfoService;
import com.weichuxing.utils.WcxServiceUtil;
import com.weichuxing.utils.common.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


public abstract class BaseController {

      @Autowired
      private  WcxServiceUtil wcxServiceUtil;

      @Autowired
      protected UserInfoService userInfoService;


     /**
     * 验证签名
     * @param baseWcxRequest
     */
      protected  void verificationSign(BaseWcxRequest baseWcxRequest, List<String> list){
          wcxServiceUtil.verificationSign(baseWcxRequest,list);
      }

    /**
     * 参数进行解码
     * @param baseWcxRequest
     * @return
     */
      protected <T> T decodeParam(BaseWcxRequest baseWcxRequest,Class<T> tClass){
          Map<String,Object> map = JSON.parseObject(JSON.toJSONString(baseWcxRequest), Map.class);
          Map<String, Object> dncoder = WcxServiceUtil.getParamMapToEncoder(map, false);
          return JSON.parseObject(JSON.toJSONString(dncoder),tClass);
      }
}
