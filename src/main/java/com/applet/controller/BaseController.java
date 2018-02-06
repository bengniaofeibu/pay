package com.applet.controller;


import com.applet.entity.Cat;
import com.applet.entity.RequestEntity;
import com.applet.enums.ResultEnums;
import com.applet.utils.AppletResult;
import com.applet.utils.ResultUtil;
import com.applet.utils.common.JSON;
import com.applet.utils.common.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class BaseController {



    @Autowired
    protected RedisUtil redisUtil;

    /**
     * 验证请求参数
     * @return
     */
    protected AppletResult validateReqParam(RequestEntity request){
        Map<String,Object> map = JSON.parseObject(JSON.toJSONString(request), Map.class);
        for (Map.Entry<String,Object> entry:map.entrySet()) {
           if (entry.getValue()==null){
                return ResultUtil.error(ResultEnums.PARAM_IS_NULL,new String[]{entry.getKey()});
           }
        }
        return null;
    }

    /**
     * 获取授权信息
     * @param session
     * @return
     */
    protected Cat getAuthInfo(String session){
     Object obj = redisUtil.getValueObj(session);
      return JSON.parseObject(JSON.toJSONString(obj),Cat.class);
    }
}
