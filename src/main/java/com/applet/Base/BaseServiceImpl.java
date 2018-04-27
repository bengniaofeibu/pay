package com.applet.Base;


import com.applet.entity.PayBackStatusNotice;
import com.applet.mapper.NyCouponMapper;
import com.applet.utils.common.BigDecimalUtil;
import com.applet.utils.common.RedisUtil;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public  abstract class BaseServiceImpl {

    @Autowired
    protected PayBackStatusNotice payBackStatusNotice;


}
