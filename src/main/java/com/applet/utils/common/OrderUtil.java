package com.applet.utils.common;

public class OrderUtil {

    /**
     * 生成订单号
     * @return
     */
    public static long generateOrderNumber(){
      StringBuilder orderBuild=new StringBuilder("99");
      orderBuild.append(System.currentTimeMillis());
      orderBuild.append(NumUtils.getThreeDigits(100));
      return Long.parseLong(orderBuild.toString());
    }
}
