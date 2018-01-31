package com.weichuxing.service.impl;

import com.weichuxing.annotation.SystemServerLog;
import com.weichuxing.entity.WcxRequest.ReportBikeFinishRequest;
import com.weichuxing.entity.WcxResponse.ReportBikeFinishResponse;
import com.weichuxing.enums.WcxResultEnum;
import com.weichuxing.exception.LockException.ReportBikeFinishException;
import com.weichuxing.model.TransRecordTemp;
import com.weichuxing.model.UserInfo;
import com.weichuxing.service.ReportBikeFinishService;
import com.weichuxing.utils.common.CommonUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReportBikeFinishServiceImpl extends BaseServer implements ReportBikeFinishService{

    @Override
    @SystemServerLog(funcionExplain = "主动结束用车")
    public ReportBikeFinishResponse reportBikeFinish(ReportBikeFinishRequest reportBikeFinishRequest){
        TransRecordTemp transRecordTemp = transRecordTempMapper.selectByPrimaryKey(reportBikeFinishRequest.getOrder_id());
        if(transRecordTemp != null){
            UserInfo userInfo = userInfoMapper.selectById(transRecordTemp.getUserId());
            if(userInfo != null){
                Date recessionDateTime = new Date();
                transRecordTemp.setState(1);
                transRecordTemp.setTransFlag(1);
                transRecordTemp.setRecessionDateTime(recessionDateTime);
                String endPosition = String.valueOf(reportBikeFinishRequest.getGps_lat()) + ","
                        + String.valueOf(reportBikeFinishRequest.getGps_lng());
                transRecordTemp.setEndPosition(endPosition);

                userInfo.setmBorrowBicycle(0);
                transRecordTempMapper.updateOrderById(transRecordTemp);
                userInfoMapper.updateBorrowBicycleById(userInfo);
                long indeedTime = (recessionDateTime.getTime() - transRecordTemp.getBorrowDateTime().getTime())/1000;
                ReportBikeFinishResponse reportBikeFinishResponse = new ReportBikeFinishResponse();
                reportBikeFinishResponse.setBike_status(1);
                reportBikeFinishResponse.setIndeed_way(0);
                reportBikeFinishResponse.setIndeed_time((int)indeedTime);
                reportBikeFinishResponse.setIndeed_fee(transRecordTemp.getTransMoney().intValue());
                return reportBikeFinishResponse;
            }else{
                throw new ReportBikeFinishException(WcxResultEnum.INVALID_USER);
            }
        }else{
            throw new ReportBikeFinishException(WcxResultEnum.ORDER_NOT_EXIST);
        }
    }
}
