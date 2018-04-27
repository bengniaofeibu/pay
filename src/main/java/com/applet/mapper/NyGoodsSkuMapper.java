package com.applet.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface NyGoodsSkuMapper {

    /**
     * 更新商品销量
     * @param goodsId
     * @return
     */
    int updateGoodsNumByGoods(@Param("goodsId") String goodsId);

}