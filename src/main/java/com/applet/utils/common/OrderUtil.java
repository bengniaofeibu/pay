package com.applet.utils.common;

public class OrderUtil {

    /**
     * 生成订单号
     * @return
     */
    public static String generateOrderNumber(){
      StringBuilder orderBuild=new StringBuilder("99");
      orderBuild.append(System.currentTimeMillis());
      orderBuild.append(NumUtils.getThreeDigits(100));
      return orderBuild.toString();
    }
}
