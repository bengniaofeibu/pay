package com.weichuxing.service;

import com.weichuxing.entity.LockRequest.CloseLockCallbackRequest;
import com.weichuxing.entity.LockRequest.OpenLockCallbackRequest;

public interface LockCallbackService {

    void openLockCallback(OpenLockCallbackRequest lockCallbackRequest);

    void closeLockCallback(CloseLockCallbackRequest closeLockCallbackRequest);
}
