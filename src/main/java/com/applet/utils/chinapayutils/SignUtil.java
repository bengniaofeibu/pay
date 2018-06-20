package com.applet.utils.chinapayutils;

import com.chinapay.secss.SecssUtil;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

@Component
public class SignUtil {

	private static final String ECURITY_PROPERTIES_PATH="/security.properties";

	private static SecssUtil secssUtil = null;

	static{

		/*
		 * 初始化security.properties属性文件
		 *
		 */
		PathUtil pathUtil=new PathUtil(ECURITY_PROPERTIES_PATH);
		secssUtil = new SecssUtil();
		secssUtil.init(pathUtil.getProperties());
	}

	public static String sign(Map signMap){
		secssUtil = new SecssUtil();
		secssUtil.init();
		secssUtil.sign(signMap);

		System.out.println(secssUtil.getErrCode());
		System.out.println(secssUtil.getErrMsg());

		return secssUtil.getSign();
	}

	public static String sign(String merId,String signData){
		return null;
	}

	public static boolean verify(Map map){
		secssUtil.verify(map);
		if("00".equals(secssUtil.getErrCode()))
			return true;
		return false;
}

	public static String decode(String merId,String decData){

		return null;
	}


	/**
	 * 加密
	 * @param encryptData
	 * @return
	 */
	public static String encryptData(String encryptData){
		secssUtil.encryptData(encryptData);
		return secssUtil.getEncValue();
	}


	/**
	 * 解密
	 * @param decryptData
	 * @return
	 */
	public static String decryptData(String decryptData){
		secssUtil.decryptData(decryptData);
		return secssUtil.getDecValue();
	}
}
