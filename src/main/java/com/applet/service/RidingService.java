package com.applet.service;

import com.applet.entity.LockRequest.EndOrderRequest;
import com.applet.entity.LockRequest.QueryRidingStatusRequest;
import com.applet.utils.AppletResult;

public interface RidingService {

    AppletResult queryRidingStatus(QueryRidingStatusRequest queryRidingStatusRequest);

    AppletResult endOrder(EndOrderRequest endOrderRequest);
}
