package com.applet.mapper;

import com.applet.model.SsycCity;

public interface SsycCityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SsycCity record);

    int insertSelective(SsycCity record);

    SsycCity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SsycCity record);

    int updateByPrimaryKey(SsycCity record);
}