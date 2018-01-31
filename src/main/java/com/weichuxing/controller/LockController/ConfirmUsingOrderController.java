package com.weichuxing.controller.LockController;

import com.weichuxing.annotation.SystemControllerLog;
import com.weichuxing.controller.BaseController;
import com.weichuxing.entity.WcxRequest.ConfirmUsingOrderRequest;
import com.weichuxing.entity.WcxResponse.ConfirmUsingOrderResponse;
import com.weichuxing.utils.ResultUtil;
import com.weichuxing.utils.WcxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfirmUsingOrderController extends BaseController {

    @SystemControllerLog(funcionExplain = "周期性确认骑行状态")
    @PostMapping(value = "/vcx_confirm_using_order.fcgi")
    public WcxResult confirmUsingOrder(ConfirmUsingOrderRequest orderInfo){
        ConfirmUsingOrderRequest confirmUsingOrderRequest = verificationSignAndDecode(orderInfo, ConfirmUsingOrderRequest.class);
        ConfirmUsingOrderResponse confirmUsingOrderResponse = confirmUsingOrderService.confirmUsingOrder(confirmUsingOrderRequest);

        return ResultUtil.success(confirmUsingOrderResponse);
    }

}
