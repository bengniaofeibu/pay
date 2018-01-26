package com.weichuxing.service.impl;

import com.weichuxing.entity.WcxRequest.BaseWcxRequest;
import com.weichuxing.entity.WcxRequest.UserAroundSignInfoRequest;
import com.weichuxing.entity.WcxResponse.TagEntityResponse;
import com.weichuxing.entity.WcxResponse.UserAroundSignInfoResponse;
import com.weichuxing.entity.YingYanAroundEntity.AroundEntities;
import com.weichuxing.entity.YingYanAroundEntity.AroundTagInfoEntity;
import com.weichuxing.entity.YingYanAroundEntity.LatestLocation;
import com.weichuxing.enums.WcxResultEnum;
import com.weichuxing.exception.UserException.InvalidUserException;
import com.weichuxing.exception.UserException.PointOrScopeNotLegalException;
import com.weichuxing.exception.UserException.YingYanServerException;
import com.weichuxing.service.YingYanAroundSearchService;
import com.weichuxing.utils.HttpClient.HttpSendUtils;
import com.weichuxing.utils.common.JSON;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class YingYanAroundSearchServiceImpl extends BaseServer implements YingYanAroundSearchService {

    private static final SimpleDateFormat DATEFOMAT=new SimpleDateFormat("yyyyMMddHHmmss");


    /**
     * 鹰眼周边搜索
     *
     * @param userAroundSignInfoRequest
     * @return
     */
    @Override
    public UserAroundSignInfoResponse queryAroundSignInfo(UserAroundSignInfoRequest userAroundSignInfoRequest) {

        Long count = wcxUserRegisterInfoMapper.selectWcxUserCount(Long.valueOf(userAroundSignInfoRequest.getOpenid()));
        if (count.longValue() == 0) {
            throw new InvalidUserException(WcxResultEnum.INVALID_USER);
        }

        int scope = userAroundSignInfoRequest.getScope();
        if (scope < 0 || scope > 5000) {
            throw  new PointOrScopeNotLegalException(WcxResultEnum.POINT_OR_SCOPE_NOT_LEGAL);
        }

        Map<String, Object> paramMap = new HashMap<>();
        StringBuffer buffer = new StringBuffer();
        buffer.append(userAroundSignInfoRequest.getUsr_gps_lat()).append(",").append(userAroundSignInfoRequest.getUsr_gps_lng());
        paramMap.put("center", buffer.toString());
        paramMap.put("radius", userAroundSignInfoRequest.getScope());
        AroundTagInfoEntity aroundTagInfo = JSON.parseObject(HttpSendUtils.sendYingYanAroundsearch(paramMap), AroundTagInfoEntity.class);
        List<TagEntityResponse> tag_list = new LinkedList<>();
        TagEntityResponse tagEntityResponse;
        UserAroundSignInfoResponse aroundSignInfoResponse = new UserAroundSignInfoResponse();
        switch (userAroundSignInfoRequest.getTag_type()){
            case 0:
            break;
            //单车类型
            case 1:
                if (aroundTagInfo.getStatus().equals(0)) {
                    long len=aroundTagInfo.getSize();
                    if (len > 0) {
                        List<AroundEntities> entities = aroundTagInfo.getEntities();
                        LatestLocation latest_location;
                        for (AroundEntities aroundEntities : entities) {
                            latest_location= aroundEntities.getLatest_location();
                            tagEntityResponse=new TagEntityResponse();
                            tagEntityResponse.setTag_type(userAroundSignInfoRequest.getTag_type().toString());
                            tagEntityResponse.setTag_gps_lat(latest_location.getLatitude());
                            tagEntityResponse.setTag_gps_lng(latest_location.getLongitude());
                            Date date=new Date();
                            date.setTime(Long.valueOf(latest_location.getLoc_time()));
                            tagEntityResponse.setTag_uptime(DATEFOMAT.format(date));
                            tag_list.add(tagEntityResponse);
                        }
                        aroundSignInfoResponse.setTags_num(len);
                        aroundSignInfoResponse.setTag_list(tag_list);
                    }else {
                        aroundSignInfoResponse.setTags_num(0L);
                    }
                }else {
                    throw  new YingYanServerException(WcxResultEnum.YINYAN_SEARCH_ERROR);
                }

                if (aroundTagInfo.getStatus().equals(1)){
                   throw  new YingYanServerException(WcxResultEnum.YINYAN_SERVER_ERROR);
                }
                break;
            case 3:
        }
        return aroundSignInfoResponse;
    }
}
