package com.applet.service;

import com.applet.entity.LockRequest.ScaveningUnlockRequest;
import com.applet.entity.LockResponse.ScaveningUnlockResponse;
import com.applet.utils.AppletResult;

public interface ScavengingUnlockService {

    AppletResult scaveningUnlock(ScaveningUnlockRequest scaveningUnlockRequest);

}
