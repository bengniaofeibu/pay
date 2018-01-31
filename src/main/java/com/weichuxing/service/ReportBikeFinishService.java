package com.weichuxing.service;

import com.weichuxing.entity.WcxRequest.ReportBikeFinishRequest;
import com.weichuxing.entity.WcxResponse.ReportBikeFinishResponse;

public interface ReportBikeFinishService {

    ReportBikeFinishResponse reportBikeFinish(ReportBikeFinishRequest reportBikeFinishRequest);
}
