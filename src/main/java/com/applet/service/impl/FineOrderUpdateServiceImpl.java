package com.applet.service.impl;

import com.applet.annotation.SystemServerLog;
import com.applet.mapper.AmountRecordMapper;
import com.applet.mapper.NoparkFineDetailMapper;
import com.applet.mapper.UserInfoMapper;
import com.applet.model.AmountRecord;
import com.applet.model.BaseOrderInfo;
import com.applet.model.NoparkFineDetail;
import com.applet.service.FineOrderUpdateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service("fineOrderUpdateService")
public class FineOrderUpdateServiceImpl implements FineOrderUpdateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FineOrderUpdateServiceImpl.class);

    @Autowired
    private AmountRecordMapper amountRecordMapper;

    @Autowired
    private NoparkFineDetailMapper noparkFineDetailMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 更新订单状态
     *
     * @param baseOrderInfo
     */
    @SystemServerLog(funcionExplain = "更新用户罚款订单状态")
    @Override
    public int updateOrderStatus(BaseOrderInfo baseOrderInfo) {

        //更新用户罚款订单
        int updateAmount = amountRecordMapper.updateOrderStateByRechargeId(new AmountRecord(new BigDecimal(baseOrderInfo.getOrderNumber()), baseOrderInfo.getTotalAmount(), Integer.valueOf(baseOrderInfo.getPayWay()),1, baseOrderInfo.getTradeNo(), baseOrderInfo.getUserPayNumber()));

        //更新用户罚款明细订单
        int updatenoparkFineDetail = noparkFineDetailMapper.updateStatusByRechargeId(new NoparkFineDetail(baseOrderInfo.getOrderNumber(),1));
        LOGGER.debug("updateAmount {} updatenoparkFineDetail {} ",updateAmount,updatenoparkFineDetail);


        //更新用户信用分到70分
        String userId = noparkFineDetailMapper.selectUserIdByRechargeId(baseOrderInfo.getOrderNumber().toString());

        userInfoMapper.updateUserCreditScore(userId);

        return updateAmount+updatenoparkFineDetail;
    }
}
