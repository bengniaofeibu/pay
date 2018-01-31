package com.weichuxing.service.impl;

import com.weichuxing.annotation.SystemServerLog;
import com.weichuxing.entity.LockRequest.CloseLockCallbackRequest;
import com.weichuxing.entity.LockRequest.OpenLockCallbackRequest;
import com.weichuxing.enums.WcxEnum;
import com.weichuxing.service.LockCallbackService;
import com.weichuxing.utils.WcxResult;
import com.weichuxing.utils.common.CommonUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LockCallbackServiceImpl extends BaseServer implements LockCallbackService{

    private static final Logger LOGGER= LoggerFactory.getLogger(LockCallbackServiceImpl.class);

    @Override
    @SystemServerLog(funcionExplain = "开锁回调")
    public void openLockCallback(OpenLockCallbackRequest lockCallbackRequest){
        Map<String,Object> lockMap = new HashMap<>();
        lockMap.put("openid",lockCallbackRequest.getOpenid());
        lockMap.put("order_id",lockCallbackRequest.getOrder_id());
        lockMap.put("bike_id",lockCallbackRequest.getBike_id());
        lockMap.put("model_id",lockCallbackRequest.getModel_id());
        lockMap.put("model_type",lockCallbackRequest.getModel_type());
        lockMap.put("bike_status",lockCallbackRequest.getBike_status());
        lockMap.put("timestamp", CommonUtils.getCurrentTimeFormat("yyyyMMddHHmmss"));

        WcxResult wcxResult = wcxServiceUtil.SendRequestToWcx(lockMap, WcxEnum.OPEN_LOCK_CALLBACK, WcxResult.class);
        JSONObject jsonObject = new JSONObject(wcxResult.getData());
        String orderStatus;
        switch (jsonObject.get("order_status").toString()){
            case "1":
                orderStatus = "待开锁 ";
                break;
            case "2":
                orderStatus = "骑行开始";
                break;
            case "3":
                orderStatus = "待支付(骑行结束)";
                break;
            case "4":
                orderStatus = "骑行成功(支付成功)";
                break;
            case "6":
                orderStatus = "异常结束 ";
                break;
            default:
                orderStatus = "unknown";
                break;
        }

        LOGGER.info("开锁回调ret:" + wcxResult.getRet());
        LOGGER.info("开锁回调msg:" + wcxResult.getMsg());
        LOGGER.info("开锁回调orderStatus:" + orderStatus);
    }

    @Override
    @SystemServerLog(funcionExplain = "关锁回调")
    public void closeLockCallback(CloseLockCallbackRequest closeLockCallbackRequest){
        Map<String,Object> lockMap = new HashMap<>();
        lockMap.put("openid",closeLockCallbackRequest.getOpenid());
        lockMap.put("order_id",closeLockCallbackRequest.getOrder_id());
        lockMap.put("bike_id",closeLockCallbackRequest.getBike_id());
        lockMap.put("model_id",closeLockCallbackRequest.getModel_id());
        lockMap.put("model_type",closeLockCallbackRequest.getModel_type());
        lockMap.put("timestamp", CommonUtils.getCurrentTimeFormat("yyyyMMddHHmmss"));
        lockMap.put("gps_lat",closeLockCallbackRequest.getGps_lat());
        lockMap.put("gps_lng",closeLockCallbackRequest.getGps_lng());
        lockMap.put("indeed_way",closeLockCallbackRequest.getIndeed_way());
        lockMap.put("indeed_time",closeLockCallbackRequest.getIndeed_time());
        lockMap.put("indeed_fee",0);
        lockMap.put("charging_fee",0);

        WcxResult wcxResult = wcxServiceUtil.SendRequestToWcx(lockMap, WcxEnum.CLOSE_LOCK_CALLBACK, WcxResult.class);
        JSONObject jsonObject = new JSONObject(wcxResult.getData());
        String orderStatus;
        switch (jsonObject.get("order_status").toString()){
            case "1":
                orderStatus = "待开锁 ";
                break;
            case "2":
                orderStatus = "骑行开始";
                break;
            case "3":
                orderStatus = "待支付(骑行结束)";
                break;
            case "4":
                orderStatus = "骑行成功(支付成功)";
                break;
            case "6":
                orderStatus = "异常结束 ";
                break;
            case "7":
                orderStatus = "骑行成功(免费)";
                break;
            default:
                orderStatus = "unknown";
                break;
        }

        String bikeStatus;
        switch(jsonObject.get("bike_status").toString()){
            case "1":
                bikeStatus = "locked";
                break;
            case "2":
                bikeStatus = "unlocked";
                break;
            default:
                bikeStatus = "unknown";
        }
        LOGGER.info("关锁回调ret:" + wcxResult.getRet());
        LOGGER.info("关锁回调msg:" + wcxResult.getMsg());
        LOGGER.info("关锁回调orderStatus:" + orderStatus);
        LOGGER.info("关锁回调bikeStatus:" + bikeStatus);
    }
}
