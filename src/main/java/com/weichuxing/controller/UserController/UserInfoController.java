package com.weichuxing.controller.UserController;

import com.weichuxing.annotation.SystemControllerLog;
import com.weichuxing.controller.BaseController;
import com.weichuxing.entity.WcxRequest.UserAroundSignInfoRequest;
import com.weichuxing.entity.WcxRequest.UserInfoRequest;
import com.weichuxing.entity.WcxResponse.UserAroundSignInfoResponse;
import com.weichuxing.entity.WcxResponse.UserInfoResponse;
import com.weichuxing.model.WcxUserRegisterInfoRequest;
import com.weichuxing.utils.WcxResult;
import com.weichuxing.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController extends BaseController {

    private static final Logger LOGGER= LoggerFactory.getLogger(UserInfoController.class);

    @SystemControllerLog(funcionExplain = "进入查询用户信息控制层")
    @GetMapping(value = "/vcx_query_user_info.fcgi")
    public WcxResult queryUserInfo(UserInfoRequest userInfo) {
            //解码和验证签名
            UserInfoRequest userInfoRequest = verificationSignAndDecode(userInfo, UserInfoRequest.class);

            //查询用户信息
           UserInfoResponse userInfoResponse = userInfoService.queryUserRegisterInfo(userInfoRequest);
        return ResultUtil.success(userInfoResponse);
    }


    @SystemControllerLog(funcionExplain = "进入查询用户周边标记控制层")
    @GetMapping(value = "/vcx_fetch_tags_around.fcgi")
    public WcxResult fetchAroundTags(UserAroundSignInfoRequest userAroundSignInfoRequest){
//            UserAroundSignInfoRequest userAroundSignInfo = verificationSignAndDecode(userAroundSignInfoRequest, UserAroundSignInfoRequest.class);
        UserAroundSignInfoResponse userAroundSignInfoResponse =  yingYanAroundSearchService.queryAroundSignInfo(userAroundSignInfoRequest);
        return ResultUtil.success(userAroundSignInfoResponse);

    }

    @SystemControllerLog(funcionExplain = "进入通知新用户注册控制层")
    @PostMapping(value = "/nvcx_notify_user_regist.fcgi")
    public WcxResult notifyUserRegist(WcxUserRegisterInfoRequest wcxUserRegisterInfo) {
            //解码和验证签名
//         WcxUserRegisterInfoRequest wcxUserRegisterInfoRequest = verificationSignAndDecode(wcxUserRegisterInfo, WcxUserRegisterInfoRequest.class);

            //操作微出行注册用户信息
            userInfoService.notifyWcxUserRegisterInfo(wcxUserRegisterInfo);
        return ResultUtil.success();
    }
}
