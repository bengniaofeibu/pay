package com.weichuxing.controller.LockController;

import com.weichuxing.annotation.SystemControllerLog;
import com.weichuxing.controller.BaseController;
import com.weichuxing.entity.WcxRequest.ScavengingUnlockRequest;
import com.weichuxing.entity.WcxResponse.ScavengingUnlockResponse;
import com.weichuxing.service.ScaveningUnlockService;
import com.weichuxing.utils.ResultUtil;
import com.weichuxing.utils.WcxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScavengingUnlockController extends BaseController {

    @SystemControllerLog(funcionExplain = "扫码开锁")
    @PostMapping(value = "/vcx_scan_bike_unlock.fcgi")
    public WcxResult scaveningUnlock(ScavengingUnlockRequest scavengingUnlockInfo){

        ScavengingUnlockRequest scavengingUnlockRequest =
                verificationSignAndDecode(scavengingUnlockInfo, ScavengingUnlockRequest.class);

        ScavengingUnlockResponse scavengingUnlockResponse = scaveningUnlockService.scavengingUnlock(scavengingUnlockRequest);

        return ResultUtil.success(scavengingUnlockResponse);
    }

}
