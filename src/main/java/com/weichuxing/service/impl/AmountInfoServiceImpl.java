package com.weichuxing.service.impl;

import com.weichuxing.model.TransRecordAmount;
import com.weichuxing.service.AmountInfoService;
import org.springframework.stereotype.Service;

@Service("amountInfoService")
public class AmountInfoServiceImpl extends BaseServer implements AmountInfoService{


    @Override
    public void addAmountRecord(TransRecordAmount transRecordAmount) {
        transRecordAmount.setResourceId(1);
        aMapper.insertSelective(transRecordAmount);
    }
}
