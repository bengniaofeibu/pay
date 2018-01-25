package com.weichuxing.service;

import com.weichuxing.entity.WcxRequest.UserAroundSignInfoRequest;
import com.weichuxing.entity.WcxResponse.UserAroundSignInfoResponse;

public interface YingYanAroundSearchService {

    /**
     * 鹰眼周边搜索
     * @param userAroundSignInfoRequest
     * @return
     */
    UserAroundSignInfoResponse queryAroundSignInfo(UserAroundSignInfoRequest userAroundSignInfoRequest);
}
