package com.applet.mapper;

import com.applet.model.SsycCounty;

public interface SsycCountyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SsycCounty record);

    int insertSelective(SsycCounty record);

    SsycCounty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SsycCounty record);

    int updateByPrimaryKey(SsycCounty record);
}