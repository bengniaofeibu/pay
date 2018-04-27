package com.applet.utils.common;

import java.util.Random;

public class NumUtils {

	public static String getThreeDigits(int rangeNum) {

		Integer num = new Random().nextInt(rangeNum) + 1;
		String str = num.toString();
		StringBuilder numStr=new StringBuilder(num.toString());
		while (numStr.length() < 3) {

			numStr = numStr.append("0").append(str) ;
		}
		return numStr.toString();

	}
}
