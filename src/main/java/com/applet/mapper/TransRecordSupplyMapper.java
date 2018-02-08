package com.applet.mapper;

import com.applet.model.TransRecordSupply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface TransRecordSupplyMapper {
    int deleteByPrimaryKey(String transId);

    int insert(TransRecordSupply record);

    int insertSelective(TransRecordSupply record);

    TransRecordSupply selectByPrimaryKey(String transId);

    int updateByPrimaryKeySelective(TransRecordSupply record);

    int updateByPrimaryKey(TransRecordSupply record);
}