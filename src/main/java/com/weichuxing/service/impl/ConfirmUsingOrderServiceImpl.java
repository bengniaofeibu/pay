package com.weichuxing.service.impl;

import com.weichuxing.annotation.SystemServerLog;
import com.weichuxing.entity.WcxRequest.ConfirmUsingOrderRequest;
import com.weichuxing.entity.WcxResponse.ConfirmUsingOrderResponse;
import com.weichuxing.enums.WcxResultEnum;
import com.weichuxing.exception.LockException.ConfirmUsingOrderException;
import com.weichuxing.mapper.TransRecordInfoMapper;
import com.weichuxing.mapper.TransRecordTempMapper;
import com.weichuxing.model.TransRecordInfo;
import com.weichuxing.model.TransRecordTemp;
import com.weichuxing.service.ConfirmUsingOrderService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ConfirmUsingOrderServiceImpl extends BaseServer implements ConfirmUsingOrderService{

    @Override
    @SystemServerLog(funcionExplain = "周期性确认骑行状态")
    public ConfirmUsingOrderResponse confirmUsingOrder(ConfirmUsingOrderRequest confirmUsingOrderRequest){

        TransRecordInfo transRecordInfo = transRecordInfoMapper.selectByPrimaryKey(confirmUsingOrderRequest.getOrder_id());
        if(transRecordInfo != null){
            long rideTime = 0;
            ConfirmUsingOrderResponse confirmUsingOrderResponse = new ConfirmUsingOrderResponse();
            if(transRecordInfo.getTransFlag() == 2){
                confirmUsingOrderResponse.setOrder_status(1); //待开始
            }else if(transRecordInfo.getTransFlag() == 0){
                Date currentTime = new Date();
                confirmUsingOrderResponse.setOrder_status(2); //骑行开始
                rideTime = currentTime.getTime() - transRecordInfo.getBorrowDateTime().getTime();
            }else if(transRecordInfo.getTransFlag() == 1){
                confirmUsingOrderResponse.setOrder_status(7); //骑行成功
                rideTime = transRecordInfo.getRecessionDateTime().getTime() - transRecordInfo.getBorrowDateTime().getTime();
            }else{
                confirmUsingOrderResponse.setOrder_status(6); //异常结束
            }
            confirmUsingOrderResponse.setIndeed_time((int) rideTime);
            confirmUsingOrderResponse.setIndeed_way(transRecordInfo.getKilometers().intValue());
            confirmUsingOrderResponse.setIndeed_fee(transRecordInfo.getTransMoney().longValue());
            return confirmUsingOrderResponse;
        }else{
            throw new ConfirmUsingOrderException(WcxResultEnum.ORDER_NOT_EXIST);
        }
    }

}
