package com.applet.mapper;

import com.applet.model.NyCustomStore;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface NyCustomStoreMapper {


    /**
     * 查询商店信息集合
     * @return
     */
    List<NyCustomStore> selectCustomStores();

}