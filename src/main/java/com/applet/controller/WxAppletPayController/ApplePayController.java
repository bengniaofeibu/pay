package com.applet.controller.WxAppletPayController;

import com.applet.annotation.SystemControllerLog;
import com.applet.controller.BaseController;
import com.applet.entity.Cat;
import com.applet.entity.WxPay.WxAppletPayCallBack;
import com.applet.entity.WxPay.WxAppletPayRequest;
import com.applet.enums.ResultEnums;
import com.applet.enums.WxCallBackResultEnums;
import com.applet.mapper.AmountRecordMapper;
import com.applet.mapper.UserInfoMapper;
import com.applet.model.AmountRecord;
import com.applet.service.WxAppleetPayService;
import com.applet.utils.AppletResult;
import com.applet.utils.ResultUtil;
import com.applet.utils.WxAppletServiceUtil;
import com.applet.utils.common.JSONUtil;
import com.applet.utils.common.StreamUtil;
import com.applet.utils.common.XmlOrMapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/pay")
public class ApplePayController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplePayController.class);

    @Autowired
    private WxAppleetPayService wxAppleetPlayService;

    @Autowired
    private AmountRecordMapper amountRecordMapper;


    @SystemControllerLog(funcionExplain = "进入微信支付控制层")
    @GetMapping(value = "/wx_xcx_appletpay")
    public AppletResult appletPlay(WxAppletPayRequest wxAppletPayRequest, HttpServletRequest request, @RequestHeader("session") String session) {

        try {

            Cat authInfo = getAuthInfo(session);
            LOGGER.debug(" authInfo {}", JSONUtil.toJSONString(authInfo));

            wxAppletPayRequest.setUserHost(request.getRemoteAddr());
            wxAppletPayRequest.setOpenId(authInfo.getOpenId());
            AppletResult appletResult = wxAppleetPlayService.appletPay(wxAppletPayRequest);
            return appletResult;
        } catch (Exception e) {
            LOGGER.error("ERROR {}", e.getMessage());
            return ResultUtil.error(ResultEnums.SERVER_ERROR);
        }
    }


    @SystemControllerLog(funcionExplain = "进入微信支付回调控制层")
    @PostMapping(value = "/wx_xcx_callback")
    public String wxCallBack(HttpServletRequest request) {
        try {
            String xmlStr = StreamUtil.inputStream2String(request.getInputStream(), "UTF-8");
            LOGGER.debug("微信支持结果通知返回内容 {}", xmlStr);

            Map<String, String> xmlTomap = XmlOrMapUtils.xmlToMap(xmlStr);
            final WxAppletPayCallBack wxAppletPayCallBack = JSONUtil.parseObject(JSONUtil.toJSONString(xmlTomap), WxAppletPayCallBack.class);

            if (wxAppletPayCallBack.getResult_code().equals("FAIL")) {
                return notifyWxCallBackResult(WxCallBackResultEnums.CALL_BACK_NOTIFY_FAIL);
            }

            //验证签名
            if (!WxAppletServiceUtil.verificationSign(wxAppletPayCallBack)) {
                LOGGER.debug("验证签名通过");
                return notifyWxCallBackResult(WxCallBackResultEnums.CALL_BACK_NOTIFY_SIGIN_FAIL);
            }

            AmountRecord amountRecord = amountRecordMapper.selectUserStatusByRechargeId(wxAppletPayCallBack.getOut_trade_no());

            if (amountRecord != null) {

                if (amountRecord.getState() == 1) {
                    LOGGER.debug("微信支付成功");
                    return notifyWxCallBackResult(WxCallBackResultEnums.CALL_BACK_NOTIFY_SUCCESS);
                }

                if (amountRecord.getAmount().intValue() != wxAppletPayCallBack.getTotal_fee()) {
                    return notifyWxCallBackResult(WxCallBackResultEnums.CALL_BACK_FEE_NOT_EQUAL_FAIL);
                }

                //更新用户订单状态
                int updateNum = wxAppleetPlayService.updateUserStatus(wxAppletPayCallBack);
                LOGGER.debug("更新订单状态数量 {}", updateNum);

                if (updateNum < 3) {
                    return notifyWxCallBackResult(WxCallBackResultEnums.CALL_BACK_NOTIFY_FAIL);
                }
            }
            LOGGER.debug("微信支付成功");
            return notifyWxCallBackResult(WxCallBackResultEnums.CALL_BACK_NOTIFY_SUCCESS);

        } catch (Exception e) {
            LOGGER.error("ERROR {}", e.getMessage());
        }
        return null;
    }
}
