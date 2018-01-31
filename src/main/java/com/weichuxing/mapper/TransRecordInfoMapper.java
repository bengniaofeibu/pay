package com.weichuxing.mapper;

import com.weichuxing.model.TransRecordInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface TransRecordInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(TransRecordInfo record);

    int insertSelective(TransRecordInfo record);

    TransRecordInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TransRecordInfo record);

    int updateByPrimaryKey(TransRecordInfo record);
}