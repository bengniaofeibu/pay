package com.applet.controller.LockController;

import com.applet.annotation.SystemControllerLog;
import com.applet.controller.BaseController;
import com.applet.entity.LockRequest.ScaveningUnlockRequest;
import com.applet.utils.AppletResult;
import com.applet.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lock")
public class ScavengingUnlockController extends BaseController{

    private static final Logger LOGGER= LoggerFactory.getLogger(ScavengingUnlockController.class);

    @SystemControllerLog(funcionExplain = "扫码开锁")
    @PostMapping(value = "/wx_xcx_openlock")
    public AppletResult scaveningUnlock(ScaveningUnlockRequest scaveningUnlockRequest){
        AppletResult appletResult = scavengingUnlockService.scaveningUnlock(scaveningUnlockRequest);
        return appletResult;
    }
}
