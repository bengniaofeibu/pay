package com.weichuxing.controller.RidingExtraController;

import com.weichuxing.annotation.SystemControllerLog;
import com.weichuxing.controller.BaseController;
import com.weichuxing.entity.RidingExtraRequest.WcxFeedBackRequest;
import com.weichuxing.entity.RidingExtraResponse.WcxTransRecordInfo;
import com.weichuxing.enums.WcxEnum;
import com.weichuxing.service.RidingExtraService;
import com.weichuxing.utils.ResultUtil;
import com.weichuxing.utils.WcxResult;
import com.weichuxing.utils.WcxServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RidingExtraController extends BaseController {

    private static final Logger LOGGER= LoggerFactory.getLogger(RidingExtraController.class);

    @Resource
    private WcxServiceUtil wcxServiceUtil;

    @Resource
    private RidingExtraService ridingExtraService;

    @SystemControllerLog(funcionExplain = "查询指定骑行订单")
    @GetMapping(value = "/vcx_mch_check_order_flow.fcgi")
    public WcxResult queryTransRecordById(@PathVariable String order_id) throws InvalidKeySpecException, NoSuchAlgorithmException {
            Map<String,Object> param = new HashMap<>();
            param.put("order_id",order_id);
            WcxTransRecordInfo wcxTransRecordInfo = wcxServiceUtil.SendRequestToWcx(param, WcxEnum.VERIFY_USER_INFO,WcxTransRecordInfo.class);
        return ResultUtil.success(wcxTransRecordInfo);
    }

    @SystemControllerLog(funcionExplain = "微出行骑行中故障报修")
    @GetMapping(value = "/vcx_repair_bike_report.fcgi")
    public WcxResult repairReport(WcxFeedBackRequest feedBack) {
        //解码和验证签名
        WcxFeedBackRequest feedBackRequest = verificationSignAndDecode(feedBack,WcxFeedBackRequest.class);

        //添加反馈信息
        ridingExtraService.insertFeedBack(feedBackRequest);
        return ResultUtil.success();
    }

}
