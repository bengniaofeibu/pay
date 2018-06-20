package com.applet.utils.chinapayutils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PathUtil {
	private Properties properties = null;

	private String propertiePath;

	public PathUtil(String propertiePath) {
		this.propertiePath = propertiePath;
		try {
			InputStream is = PathUtil.class.getResourceAsStream(propertiePath);
			properties = new Properties();
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据key值取得对应的value值
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		return properties.getProperty(key);
	}

	public  Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
}
