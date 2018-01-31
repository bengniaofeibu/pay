package com.weichuxing.service.impl;

import com.weichuxing.entity.RidingExtraRequest.WcxFeedBackRequest;
import com.weichuxing.model.FeedBackInfo;
import com.weichuxing.mapper.FeedBackInfoMapper;
import com.weichuxing.service.RidingExtraService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RidingExtraServiceImpl implements RidingExtraService {

    @Resource
    private FeedBackInfoMapper feedBackInfoMapper;

    @Override
    public int insertFeedBack(WcxFeedBackRequest feedBackRequest) {
        FeedBackInfo feedBackInfo = new FeedBackInfo();
        feedBackInfo.setAddTime(new Date());
        feedBackInfo.setBicycleNum(Integer.parseInt(feedBackRequest.getBike_id()));
        if(!StringUtils.isEmpty(feedBackRequest.getFaulty_desc())){
            feedBackInfo.setDescription(feedBackRequest.getFaulty_desc());
        }
        if(!StringUtils.isEmpty(feedBackRequest.getGps_lat())){
            feedBackInfo.setBikeLat(String.valueOf(feedBackRequest.getGps_lat()));
        }
        if(!StringUtils.isEmpty(feedBackRequest.getGps_lng())){
            feedBackInfo.setBikeLng(String.valueOf(feedBackRequest.getGps_lng()));
        }
        feedBackInfo.setId(UUID.randomUUID().toString().replace("-",""));
        feedBackInfo.setOpenId(feedBackRequest.getOpenid());
        feedBackInfo.setPlatform(2);
        feedBackInfo.setType(2);
        feedBackInfo.setTransId(feedBackRequest.getOrder_id());
        String[] wcxFaultIds = feedBackRequest.getFaulty_parts().split("|");
        StringBuilder sonTypeSb = new StringBuilder();
        for(String faultId:wcxFaultIds){
            switch(faultId){
                case "1":
                    sonTypeSb.append("6");
                    break;
                case "2":
                    sonTypeSb.append("3");
                    break;
                case "3":
                    sonTypeSb.append("99");
                    break;
                case "4":
                    sonTypeSb.append("5");
                    break;
                case "5":
                    sonTypeSb.append("7");
                    break;
                case "6":
                    sonTypeSb.append("8");
                    break;
                case "7":
                    sonTypeSb.append("2");
                    break;
                case "8":
                    sonTypeSb.append("99");
                    break;
                default:
                    sonTypeSb.append("99");
            }
        }
        feedBackInfo.setSonType(sonTypeSb.toString());
        return feedBackInfoMapper.insert(feedBackInfo);
    }
}
