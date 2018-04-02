package com.applet.mapper;

import com.applet.model.SsycProvice;

public interface SsycProviceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SsycProvice record);

    int insertSelective(SsycProvice record);

    SsycProvice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SsycProvice record);

    int updateByPrimaryKey(SsycProvice record);
}