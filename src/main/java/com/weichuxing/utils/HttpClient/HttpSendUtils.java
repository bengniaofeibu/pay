package com.weichuxing.utils.HttpClient;


import com.weichuxing.enums.EnumsService;
import com.weichuxing.enums.WcxEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Component
public class HttpSendUtils {
	private static String recEncoding = "UTF-8";

	@Value("${wcx.serviceUrl}")
	private String url;

	public static String getRecEncoding() {
		return recEncoding;
	}


	//调用微出行公共请求方法
	public String  sendRequest(Map<String,Object> params, WcxEnum wcxEnum){
		String result;
		StringBuffer sb=new StringBuffer(url);
		String url=sb.append(wcxEnum.getReqUrl()).toString();
		switch (wcxEnum.getReqMethod()){
			case EnumsService.getMethod:
				result=HttpRequestProxy.doGet(url, params, getRecEncoding());
			break;
			case EnumsService.postMethod:
				result=HttpRequestProxy.doPost(url,params,getRecEncoding());
			break;
			default:
				result=HttpRequestProxy.doGet(url, params, getRecEncoding());
		}
		return result;
	}
}
