package com.applet.mapper;

import com.applet.model.AmountRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface AmountRecordMapper {


    int insertSelective(AmountRecord record);

    AmountRecord selectUserStatusByRechargeId(String rechargeId);

    int updateUserStatusById(AmountRecord record);

    int updateByPrimaryKey(AmountRecord record);
}