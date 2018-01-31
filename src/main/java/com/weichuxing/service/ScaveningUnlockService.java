package com.weichuxing.service;

import com.weichuxing.entity.WcxRequest.ScavengingUnlockRequest;
import com.weichuxing.entity.WcxResponse.ScavengingUnlockResponse;
import com.weichuxing.model.WcxUserRegisterInfoRequest;
import com.weichuxing.utils.WcxResult;

public interface ScaveningUnlockService {

    ScavengingUnlockResponse scavengingUnlock(ScavengingUnlockRequest scavengingUnlockRequest);

}
