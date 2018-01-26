package com.weichuxing.controller;

import com.weichuxing.entity.WcxRequest.BaseWcxRequest;
import com.weichuxing.service.UserInfoService;
import com.weichuxing.service.YingYanAroundSearchService;
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


      @Autowired
      protected YingYanAroundSearchService yingYanAroundSearchService;

     /**
     * 验证签名
     * @param baseWcxRequest
     */
      private   void verificationSign(BaseWcxRequest baseWcxRequest){
          wcxServiceUtil.verificationSign(baseWcxRequest);
      }

    /**
     * 参数进行解码
     * @param baseWcxRequest
     * @return
     */
     private <T> T decodeParam(BaseWcxRequest baseWcxRequest,Class<T> tClass){
          Map<String,Object> map = JSON.parseObject(JSON.toJSONString(baseWcxRequest), Map.class);
          Map<String, Object> decode = WcxServiceUtil.getParamMapToEncoder(map, false);
          return JSON.parseObject(JSON.toJSONString(decode),tClass);
      }

    /**
     * 验证签名和参数进行解码
     * @param baseWcxRequest
     * @param tClass
     * @param <T>
     * @return
     */
      protected <T> T verificationSignAndDecode(BaseWcxRequest baseWcxRequest,Class<T> tClass){
          //验证签名
          verificationSign(baseWcxRequest);
         return decodeParam(baseWcxRequest,tClass);
      }
}
