package com.applet.utils.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

public  abstract class BigDecimalUtil {


    /**
     * 相减
     * @param bigDecimal1
     * @param bigDecimal2
     * @return
     */
    public static BigDecimal subtract(BigDecimal bigDecimal1,BigDecimal bigDecimal2){

        if (bigDecimal1 == null || bigDecimal2 == null){
            return null;
        }

        return bigDecimal1.subtract(bigDecimal2);
    }

    /**
     * 相乘
     * @param bigDecimal1
     * @param bigDecimal2
     * @return
     */
    public static BigDecimal multiply(BigDecimal bigDecimal1,BigDecimal bigDecimal2){

        if (bigDecimal1 == null || bigDecimal2 == null){
            return null;
        }

         return bigDecimal1.multiply(bigDecimal2);
    }

    /**
     * 相除
     * @param bigDecimal1
     * @param bigDecimal2
     * @return
     */
    public static BigDecimal divide(BigDecimal bigDecimal1,BigDecimal bigDecimal2,int digits){

        if (bigDecimal1 == null || bigDecimal2 == null){
            return null;
        }

        if ( digits < 0){
            digits =0;
        }

        return bigDecimal1.divide(bigDecimal2,digits, RoundingMode.HALF_UP);
    }
}
