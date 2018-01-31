package com.weichuxing.controller.LockController;

import com.weichuxing.annotation.SystemControllerLog;
import com.weichuxing.controller.BaseController;
import com.weichuxing.entity.WcxRequest.ReportBikeFinishRequest;
import com.weichuxing.entity.WcxResponse.ReportBikeFinishResponse;
import com.weichuxing.utils.ResultUtil;
import com.weichuxing.utils.WcxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportBikefinishController extends BaseController{

    @SystemControllerLog(funcionExplain = "主动结束用车")
    @PostMapping(value = "/vcx_report_bike_finish.fcgi")
    public WcxResult reportBikeFinish(ReportBikeFinishRequest reportBikeFinishInfo){
        ReportBikeFinishRequest reportBikeFinishRequest =
                verificationSignAndDecode(reportBikeFinishInfo,ReportBikeFinishRequest.class);

        ReportBikeFinishResponse reportBikeFinishResponse = reportBikeFinishService.reportBikeFinish(reportBikeFinishRequest);

        return ResultUtil.success(reportBikeFinishResponse);
    }
}
