package com.weichuxing.service;

import com.weichuxing.entity.RidingExtraRequest.WcxFeedBackRequest;
import com.weichuxing.model.FeedBackInfo;


public interface RidingExtraService {
    public int insertFeedBack(WcxFeedBackRequest feedBackRequest);
}
