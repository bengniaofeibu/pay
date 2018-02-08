package com.applet.controller.WxAppletPayController;

import com.applet.annotation.SystemControllerLog;
import com.applet.controller.BaseController;
import com.applet.entity.Cat;
import com.applet.entity.WxPay.WxAppletPayRequest;
import com.applet.enums.ResultEnums;
import com.applet.service.WxAppleetPayService;
import com.applet.utils.AppletResult;
import com.applet.utils.ResultUtil;
import com.applet.utils.common.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/pay")
public class ApplePayController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplePayController.class);

    @Autowired
    private WxAppleetPayService wxAppleetPlayService;


    @SystemControllerLog(funcionExplain = "进入微信支付控制层")
    @GetMapping(value = "/wx_xcx_appletpay")
    public AppletResult appletPlay(WxAppletPayRequest wxAppletPayRequest, HttpServletRequest request, @RequestHeader("session")String session) {

        try {

            Cat authInfo = getAuthInfo(session);
            LOGGER.debug(" authInfo {}", JSONUtil.toJSONString(authInfo));

            wxAppletPayRequest.setUserHost(request.getRemoteAddr());
            wxAppletPayRequest.setOpenId(authInfo.getOpenId());
            AppletResult appletResult1 = wxAppleetPlayService.appletPay(wxAppletPayRequest);
            return appletResult1;
        } catch (Exception e) {
            LOGGER.error("ERROR {}", e.getMessage());
            return ResultUtil.error(ResultEnums.SERVER_ERROR);
        }
    }
}
