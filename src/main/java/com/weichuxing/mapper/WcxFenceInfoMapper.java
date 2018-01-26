package com.weichuxing.mapper;

import com.weichuxing.model.WcxFenceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface WcxFenceInfoMapper {

    List<WcxFenceInfo> selectPointByCityName(String areaName);

}