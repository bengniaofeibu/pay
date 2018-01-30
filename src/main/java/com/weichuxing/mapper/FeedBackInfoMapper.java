package com.weichuxing.mapper;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.weichuxing.model.FeedBackInfo;

public interface FeedBackInfoMapper {

    int insert(@Param("pojo") FeedBackInfo pojo);

    int insertList(@Param("pojos") List< FeedBackInfo> pojo);

    List<FeedBackInfo> select(@Param("pojo") FeedBackInfo pojo);

    int update(@Param("pojo") FeedBackInfo pojo);

}
