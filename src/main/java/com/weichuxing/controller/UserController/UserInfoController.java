package com.weichuxing.controller.UserController;

import com.weichuxing.annotation.SystemControllerLog;
import com.weichuxing.controller.BaseController;
import com.weichuxing.entity.WcxRequest.BaseWcxRequest;
import com.weichuxing.entity.WcxRequest.UserInfoRequest;
import com.weichuxing.entity.WcxResponse.UserInfoResponse;
import com.weichuxing.utils.WcxResult;
import com.weichuxing.utils.ResultUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController()
public class UserInfoController extends BaseController {



    @SystemControllerLog(funcionExplain = "进入查询用户信息控制层")
    @GetMapping(value = "/vcx_query_user_info.fcgi")
    public WcxResult queryUserInfo(UserInfoRequest userInfo){

        UserInfoRequest userInfoRequest = decodeParam(userInfo, UserInfoRequest.class);
        //验证签名
       verificationSign(userInfoRequest, Arrays.asList("openId"));
        //查询用户信息
        UserInfoResponse  userInfoResponse = userInfoService.queryUserRegisterInfo(userInfoRequest);
        return ResultUtil.success(userInfoResponse);
    }
}
