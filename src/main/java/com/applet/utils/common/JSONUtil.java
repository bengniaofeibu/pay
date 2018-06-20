package com.applet.utils.common;

import com.applet.model.UserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class JSONUtil {

	private static final Logger LOGGER= LoggerFactory.getLogger(JSONUtil.class);

	public static String toJSONString(Object object) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static <T> T parseObject(String text, Class<T> clazz) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(text, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String parseResponseToStr(HttpResponse httpResonse) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(httpResonse.getEntity().getContent(),"utf-8"));
		StringBuffer sb = new StringBuffer();
		String str = null;
		while((str = br.readLine())!=null){
			sb.append(str);
		}
		return sb.toString();
	}

	public static Map<String, String> paserStrtoMap(String respStr) {
		Map<String, String> data = new HashMap<String, String>();
		if (!StringUtils.isBlank(respStr)) {
			String[] strs = respStr.split("&");
			for (String str : strs) {
				if (StringUtils.isBlank(str)) {
					continue;
				}
				int index = str.indexOf("=");

				if (index == -1){
					return  data;
				}
				data.put(str.substring(0, index),str.substring(index+1));
			}
		}
		return data;
	}


	/**
	 * 对象转换成web
	 * @param t
	 * @return
	 */
	public static Map objectToMap(Object t){
		try {
			if (t != null){
				return parseObject(toJSONString(t), Map.class);
			}
		}catch (Exception e){
			LOGGER.error("对象转成Map出错 {}",e);
		}
		return null;
	}
}
