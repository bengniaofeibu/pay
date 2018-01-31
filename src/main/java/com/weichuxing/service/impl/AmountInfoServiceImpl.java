package com.weichuxing.service.impl;

import com.weichuxing.mapper.TransRecordAmountMapper;
import com.weichuxing.model.TransRecordAmount;
import com.weichuxing.service.AmountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmountInfoServiceImpl extends BaseServer implements AmountInfoService{

    @Autowired
    private TransRecordAmountMapper aMapper;

    @Override
    public void addAmountRecord(TransRecordAmount transRecordAmount) {
        transRecordAmount.setResourceId(1);
        aMapper.insertSelective(transRecordAmount);
    }
}
