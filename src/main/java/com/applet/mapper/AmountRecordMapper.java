package com.applet.mapper;

import com.applet.model.AmountRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface AmountRecordMapper {

    /**
     * 更新订单状态
     * @param record
     * @return
     */
    int updateOrderStateByRechargeId(AmountRecord record);


    /**
     * 查询订单信息
     * @param userId
     * @return
     */
    AmountRecord selectOrderInfoByUserId(@Param("userId") String userId);
}