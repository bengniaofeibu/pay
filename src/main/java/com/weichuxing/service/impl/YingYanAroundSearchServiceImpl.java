package com.weichuxing.service.impl;

import com.weichuxing.entity.WcxRequest.UserAroundSignInfoRequest;
import com.weichuxing.entity.WcxResponse.TagEntityResponse;
import com.weichuxing.entity.WcxResponse.UserAroundSignInfoResponse;
import com.weichuxing.entity.YingYanAroundEntity.AroundEntities;
import com.weichuxing.entity.YingYanAroundEntity.AroundTagInfoEntity;
import com.weichuxing.entity.YingYanAroundEntity.CityInfo;
import com.weichuxing.entity.YingYanAroundEntity.LatestLocation;
import com.weichuxing.enums.WcxResultEnum;
import com.weichuxing.exception.UserException.InvalidUserException;
import com.weichuxing.exception.UserException.PointOrScopeNotLegalException;
import com.weichuxing.exception.UserException.YingYanServerException;
import com.weichuxing.model.WcxFenceInfo;
import com.weichuxing.service.YingYanAroundSearchService;
import com.weichuxing.utils.HttpClient.HttpSendUtils;
import com.weichuxing.utils.common.JSON;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class YingYanAroundSearchServiceImpl extends BaseServer implements YingYanAroundSearchService {

    private static final SimpleDateFormat DATEFOMAT = new SimpleDateFormat("yyyyMMddHHmmss");


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
            throw new PointOrScopeNotLegalException(WcxResultEnum.POINT_OR_SCOPE_NOT_LEGAL);
        }

        Map<String, Object> paramMap = new HashMap<>();
        StringBuffer buffer = new StringBuffer();
        buffer.append(userAroundSignInfoRequest.getUsr_gps_lat()).append(",").append(userAroundSignInfoRequest.getUsr_gps_lng());
        paramMap.put("center", buffer.toString());
        paramMap.put("radius", userAroundSignInfoRequest.getScope());
        AroundTagInfoEntity aroundTagInfo = JSON.parseObject(HttpSendUtils.sendYingYanAroundsearch(paramMap), AroundTagInfoEntity.class);
        UserAroundSignInfoResponse aroundSignInfoResponse = new UserAroundSignInfoResponse();
        List<AroundEntities> entities = aroundTagInfo.getEntities();

        List<WcxFenceInfo> wcxFenceInfosList;
        String result = HttpSendUtils.SendMapCityInfo();
        CityInfo cityInfo = JSON.parseObject(result, CityInfo.class);

        if (!aroundTagInfo.getStatus().equals(1) && !aroundTagInfo.getStatus().equals(0) && !cityInfo.getStatus().equals(0)) {
            throw new YingYanServerException(WcxResultEnum.YINYAN_SEARCH_ERROR);
        }

        if (aroundTagInfo.getStatus().equals(1) || cityInfo.getStatus().equals(1)) {
            throw new YingYanServerException(WcxResultEnum.YINYAN_SERVER_ERROR);
        }

        switch (userAroundSignInfoRequest.getTag_type()) {
            case 0:
                List<TagEntityResponse> aroundList = addAroundTagInfo(entities, userAroundSignInfoRequest);

                wcxFenceInfosList = wcxFenceInfoMapper.selectPointByCityName(cityInfo.getContent().getAddress());
                List<TagEntityResponse> fenceList = addFenceInfo(wcxFenceInfosList, userAroundSignInfoRequest);

                int tagSize = aroundList.size();
                int fenceSize = fenceList.size();
                aroundSignInfoResponse.setTags_num((long) (tagSize + fenceSize));

                if (tagSize != 0 && fenceSize != 0) {
                    aroundList.addAll(fenceList);
                    aroundSignInfoResponse.setTag_list(aroundList);
                }
                if (tagSize != 0 && fenceSize == 0) {
                    aroundSignInfoResponse.setTag_list(aroundList);
                }
                if (tagSize == 0 && fenceSize != 0) {
                    aroundSignInfoResponse.setTag_list(fenceList);
                }

                break;
            //单车类型
            case 1:
                long tagLen = aroundTagInfo.getSize();
                if (tagLen > 0) {
                    List<TagEntityResponse> aroundTagInfolist = addAroundTagInfo(entities, userAroundSignInfoRequest);
                    aroundSignInfoResponse.setTags_num(tagLen);
                    aroundSignInfoResponse.setTag_list(aroundTagInfolist);
                } else {
                    aroundSignInfoResponse.setTags_num(0L);
                }
                break;
            case 3:
                //围栏
                wcxFenceInfosList = wcxFenceInfoMapper.selectPointByCityName(cityInfo.getContent().getAddress());
                long fenceLen = wcxFenceInfosList.size();
                if (wcxFenceInfosList != null && fenceLen > 0) {
                    List<TagEntityResponse> fenceInfoList = addFenceInfo(wcxFenceInfosList, userAroundSignInfoRequest);
                    aroundSignInfoResponse.setTags_num(fenceLen);
                    aroundSignInfoResponse.setTag_list(fenceInfoList);
                } else {
                    aroundSignInfoResponse.setTags_num(0L);
                }

        }
        return aroundSignInfoResponse;
    }

    /**
     * 封装周边车辆信息
     * @param entities
     * @param userAroundSignInfoRequest
     * @return
     */
    private List<TagEntityResponse> addAroundTagInfo(List<AroundEntities> entities, UserAroundSignInfoRequest userAroundSignInfoRequest) {
        TagEntityResponse tagEntityResponse;
        LatestLocation latest_location;
        List<TagEntityResponse> tag_list = new LinkedList<>();
        for (AroundEntities aroundEntities : entities) {
            latest_location = aroundEntities.getLatest_location();
            tagEntityResponse = new TagEntityResponse();
            tagEntityResponse.setTag_type(userAroundSignInfoRequest.getTag_type().toString());
            tagEntityResponse.setTag_gps_lat(latest_location.getLatitude());
            tagEntityResponse.setTag_gps_lng(latest_location.getLongitude());
            Date date = new Date();
            date.setTime(Long.valueOf(latest_location.getLoc_time()));
            tagEntityResponse.setTag_uptime(DATEFOMAT.format(date));
            tag_list.add(tagEntityResponse);
        }
        return tag_list;
    }


    /**
     * 封装周边围栏信息
     * @param wcxFenceInfosList
     * @param userAroundSignInfoRequest
     * @return
     */
    private List<TagEntityResponse> addFenceInfo(List<WcxFenceInfo> wcxFenceInfosList, UserAroundSignInfoRequest userAroundSignInfoRequest) {
        List<TagEntityResponse> tag_list = new LinkedList<>();
        TagEntityResponse tagEntityResponse;
        for (WcxFenceInfo wcxFenceInfos : wcxFenceInfosList) {
            tagEntityResponse = new TagEntityResponse();
            tagEntityResponse.setTag_type(userAroundSignInfoRequest.getTag_type().toString());
            tagEntityResponse.setTag_gps_lat(wcxFenceInfos.getLatitude());
            tagEntityResponse.setTag_gps_lng(wcxFenceInfos.getLongitude());
            Date date = new Date();
            date.setTime(wcxFenceInfos.getUpdateDate().getTime());
            tagEntityResponse.setTag_uptime(DATEFOMAT.format(date));
            tag_list.add(tagEntityResponse);
        }
        return tag_list;
    }
}
