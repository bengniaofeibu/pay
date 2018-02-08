package com.applet.mapper;

import com.applet.model.FeedbackInfo;

public interface FeedbackInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(FeedbackInfo record);

    int insertSelective(FeedbackInfo record);

    FeedbackInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FeedbackInfo record);

    int updateByPrimaryKey(FeedbackInfo record);
}