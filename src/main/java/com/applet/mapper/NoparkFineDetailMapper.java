package com.applet.mapper;

import com.applet.model.NoparkFineDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface NoparkFineDetailMapper {

    NoparkFineDetail selectRechargeIdByUserIdAndStatus(String id);


    int selectPaySuccessCountByRechargeId(@Param("rechargeId") String rechargeId);

    String selectUserIdByRechargeId(@Param("rechargeId") String rechargeId);

    int updateStatusByRechargeId(NoparkFineDetail record);

}