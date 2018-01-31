package com.weichuxing.service;

import com.weichuxing.entity.WcxRequest.ConfirmUsingOrderRequest;
import com.weichuxing.entity.WcxResponse.ConfirmUsingOrderResponse;

public interface ConfirmUsingOrderService {

    ConfirmUsingOrderResponse confirmUsingOrder(ConfirmUsingOrderRequest confirmUsingOrderRequest);
}
