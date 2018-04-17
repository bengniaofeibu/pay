package com.applet.utils.common;

import java.util.Random;

public class NumUtils {

	public static String getThreeDigits(int rangeNum) {

		Integer num = new Random().nextInt(rangeNum) + 1;
		String str = num.toString();
		while (str.length() < 3) {

			str = "0" + str;
		}
		return str;

	}

	public static void main(String[] args) {
		String threeDigits = NumUtils.getThreeDigits(10);
		System.out.println(threeDigits);
	}
}
