package com.weichuxing.utils.common;

import com.wxapplet.config.HttpRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;


public class PostRequestUtils {
   private static final String APPLICATION_JSON = "application/json";

    private static final String CONTENT_TYPE_TEXT_JSON = "text/json";

    public static String httpPostWithJSON(String url, String json){
        String result = "-1";
        try{
            // 将JSON进行UTF-8编码,以便传输中文
            //String encoderJson = URLEncoder.encode(json, "UTF-8");

            HttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(HttpRequest.requestConfig).build();
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
            httpPost.setHeader("Accept", "application/json");
            StringEntity se = new StringEntity(json, Charset.forName("UTF-8"));
            se.setContentType(CONTENT_TYPE_TEXT_JSON);
            //    se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
            se.setContentEncoding("UTF-8");
            httpPost.setEntity(se);

            HttpResponse response = httpClient.execute(httpPost);
            if(200 == response.getStatusLine().getStatusCode()){
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, Consts.UTF_8);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if(StringUtils.isEmpty(result)){
            result = "-1";
        }
        return result;
    }

}
