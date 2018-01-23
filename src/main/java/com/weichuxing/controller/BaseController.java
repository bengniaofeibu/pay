package com.weichuxing.controller;

import com.weichuxing.entity.WcxRequest.BaseWcxRequest;
import com.weichuxing.service.UserInfoService;
import com.weichuxing.utils.WcxServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class BaseController {

      @Autowired
      private  WcxServiceUtil wcxServiceUtil;

      @Autowired
      protected UserInfoService userInfoService;


     /**
     * 验证签名
     * @param baseWcxRequest
     */
      protected  void verificationSign(BaseWcxRequest baseWcxRequest){
          wcxServiceUtil.verificationSign(baseWcxRequest);
      }
}
