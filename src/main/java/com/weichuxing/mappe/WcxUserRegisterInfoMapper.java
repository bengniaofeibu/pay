package com.weichuxing.mappe;

import com.weichuxing.model.WcxUserRegisterInfo;

public interface WcxUserRegisterInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(WcxUserRegisterInfo record);

    int insertSelective(WcxUserRegisterInfo record);

    WcxUserRegisterInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WcxUserRegisterInfo record);

    int updateByPrimaryKey(WcxUserRegisterInfo record);
}