package com.weichuxing.utils.HttpClient;


import com.weichuxing.entity.YingYanAroundEntity.AroundTagInfoEntity;
import com.weichuxing.enums.EnumsService;
import com.weichuxing.enums.WcxEnum;
import com.weichuxing.utils.common.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HttpSendUtils {
	private static String recEncoding = "UTF-8";

	@Value("${wcx.serviceUrl}")
	private String url;

	private static final String YING_YAN_AROUND_SEARCH_URL="http://yingyan.baidu.com/api/v3/entity/aroundsearch";

	private static final String AK="IK5AlGXoZ23tDAGjldRalicbhdpsrKwE";

	private static final String SERVICE_ID="135958";

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

	public static String sendYingYanAroundsearch(Map<String,Object> params){
		params.put("ak",AK);
		params.put("service_id",SERVICE_ID);
	    String result=HttpRequestProxy.doGet(YING_YAN_AROUND_SEARCH_URL,params,getRecEncoding());
        return result;
	}

	public static void main(String[] args) {
		Map<String,Object> map=new HashMap<>();
		map.put("center","31.185034,121.37082");
		map.put("radius",500);
		String s = sendYingYanAroundsearch(map);
		AroundTagInfoEntity aroundTagInfoEntity = JSON.parseObject(s, AroundTagInfoEntity.class);
		System.out.println(aroundTagInfoEntity.getEntities());

	}
}
