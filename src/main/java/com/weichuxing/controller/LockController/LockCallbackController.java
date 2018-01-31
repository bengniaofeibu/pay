package com.weichuxing.controller.LockController;

import com.weichuxing.annotation.SystemControllerLog;
import com.weichuxing.controller.BaseController;
import com.weichuxing.entity.LockRequest.CloseLockCallbackRequest;
import com.weichuxing.entity.LockRequest.OpenLockCallbackRequest;
import com.weichuxing.utils.ResultUtil;
import com.weichuxing.utils.WcxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LockCallbackController extends BaseController{

    private static final Logger LOGGER= LoggerFactory.getLogger(LockCallbackController.class);

    @SystemControllerLog(funcionExplain = "开锁回调")
    @PostMapping(value = "/open_lock_call_back")
    public WcxResult openLockCallback(OpenLockCallbackRequest lockCallbackInfo){
        OpenLockCallbackRequest openLockCallbackRequest = decodeLock(lockCallbackInfo, OpenLockCallbackRequest.class);

        lockCallbackService.openLockCallback(openLockCallbackRequest);
        return ResultUtil.success();
    }

    @SystemControllerLog(funcionExplain = "关锁回调")
    @PostMapping(value = "/close_lock_call_back")
    public WcxResult closeLockCallback(CloseLockCallbackRequest closeLockCallbackInfo){
        CloseLockCallbackRequest closeLockCallbackRequest = decodeLock(closeLockCallbackInfo, CloseLockCallbackRequest.class);

        lockCallbackService.closeLockCallback(closeLockCallbackRequest);
        return ResultUtil.success();
    }


}
