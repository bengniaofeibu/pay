package com.weichuxing.service;

import com.weichuxing.entity.WcxRequest.UserInfoRequest;
import com.weichuxing.entity.WcxResponse.UserInfoResponse;

public interface UserInfoService {

      /**
       * 查询用户是否注册 是否缴纳押金
       * @param userInfoRequest
       * @return
       */
      UserInfoResponse queryUserRegisterInfo(UserInfoRequest userInfoRequest);

}
