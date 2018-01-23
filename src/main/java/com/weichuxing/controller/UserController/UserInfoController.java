package com.weichuxing.controller.UserController;

import com.weichuxing.annotation.SystemControllerLog;
import com.weichuxing.controller.BaseController;
import com.weichuxing.entity.WcxRequest.UserInfoRequest;
import com.weichuxing.entity.WcxResponse.UserInfoResponse;
import com.weichuxing.entity.WcxResponse.WcxResult;
import com.weichuxing.utils.ResultUtil;
import com.weichuxing.utils.WcxServiceUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserInfoController extends BaseController {



    @SystemControllerLog(funcionExplain = "进入查询用户信息控制层")
    @GetMapping(value = "/vcx_query_user_info.fcgi")
    public WcxResult queryUserInfo(UserInfoRequest userInfo){
        //验证签名
       verificationSign(userInfo);
        //查询用户信息
        UserInfoResponse  userInfoResponse = userInfoService.queryUserRegisterInfo(userInfo);
        return ResultUtil.success(userInfoResponse);
    }
}
