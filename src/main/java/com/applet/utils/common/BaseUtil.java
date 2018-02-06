package com.applet.utils.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.UUID;

@Component
public class BaseUtil {

    private static final Logger LOGGER= LoggerFactory.getLogger(BaseUtil.class);

    private static final String ENCODE="UTF-8";

    /**
     * 获取UUID
     * @return
     */
    public static String getRandomUUID(){
        StringBuffer stringBuffer=new StringBuffer(UUID.randomUUID().toString());
       return replaceString(stringBuffer.toString(),"-","").substring(0,16);
    }

    /**
     *
     * 替换字符串
     * @param str
     * @param regex
     * @param replacement
     * @return
     */
    public static String replaceString(String str,String regex, String replacement ){
         return str.replaceAll(regex,replacement);
    }


    /**
     * 进行URL参数编码
     * @param str
     * @param str
     * @return
     */
    public static String getURLEncoder(String str){
        try {
           return URLEncoder.encode(str,ENCODE);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("编码失败  ERROR {}",e.getMessage());
        }
        return "";
    }

    /**
     * 进行URL参数解码
     * @param str
     * @return
     */
    public static String getURLDecode(String str){
        try {
            return URLDecoder.decode(str,ENCODE);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("解码失败  ERROR {}",e.getMessage());
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(getRandomUUID());
    }
}
