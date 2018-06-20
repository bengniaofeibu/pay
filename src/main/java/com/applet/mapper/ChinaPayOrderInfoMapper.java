package com.applet.mapper;

import com.applet.model.ChinaPayOrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ChinaPayOrderInfoMapper {

    int insertChinaPayInfo(ChinaPayOrderInfo record);

    int updateByPrimaryKeySelective(ChinaPayOrderInfo record);

}