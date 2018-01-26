package com.weichuxing.mapper;

import com.weichuxing.model.WcxFenceInfo;

public interface WcxFenceInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(WcxFenceInfo record);

    int insertSelective(WcxFenceInfo record);

    WcxFenceInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WcxFenceInfo record);

    int updateByPrimaryKey(WcxFenceInfo record);
}