package com.applet.mapper;

import com.applet.model.AmountRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface AmountRecordMapper {


    int insertSelective(AmountRecord record);

    AmountRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AmountRecord record);

    int updateByPrimaryKey(AmountRecord record);
}