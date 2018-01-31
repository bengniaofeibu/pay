package com.weichuxing.mapper;

import com.weichuxing.model.TransRecordAmount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface TransRecordAmountMapper {

    int insertSelective(TransRecordAmount record);

    TransRecordAmount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransRecordAmount record);
}