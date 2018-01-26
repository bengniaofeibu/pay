package com.weichuxing.service;

import com.weichuxing.entity.WcxRequest.UserInfoRequest;
import com.weichuxing.model.WcxUserRegisterInfoRequest;
import com.weichuxing.entity.WcxResponse.UserInfoResponse;

public interface UserInfoService {

      /**
       * 查询用户是否注册 是否缴纳押金
       * @param userInfoRequest
       * @return
       */
      UserInfoResponse queryUserRegisterInfo(UserInfoRequest userInfoRequest);

      /**
       * 操作微出行用户注册信息
       * @param wcxUserRegisterInfo
       */
      void notifyWcxUserRegisterInfo(WcxUserRegisterInfoRequest wcxUserRegisterInfo);

}
