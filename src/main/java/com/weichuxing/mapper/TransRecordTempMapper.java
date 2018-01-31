package com.weichuxing.mapper;

import com.weichuxing.model.TransRecordTemp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface TransRecordTempMapper {
    int deleteByPrimaryKey(String id);

    int insert(TransRecordTemp record);

    int insertSelective(TransRecordTemp record);

    TransRecordTemp selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TransRecordTemp record);

    int updateByPrimaryKey(TransRecordTemp record);

    int updateOrderById(TransRecordTemp record);
}