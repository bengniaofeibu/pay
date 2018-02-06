package com.applet.utils.common;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.util.*;

@Component
public class RequestValueUtils {


    /**
     * 对传入的参数按照ASCII 码从小到大排序（字典序）
     *
     * @return
     */
    public static String formatParameters(Map<String,Object> paramMap,boolean encode){
        Map<String,Object> valueMap=paramMap;
        StringBuffer stringBuffer=new StringBuffer();
        try {
         List<Map.Entry<String,Object>> paramList=new ArrayList<>(valueMap.entrySet());
         //按照ASCII 码从小到大排序（字典序）
        Collections.sort(paramList, Comparator.comparing(Map.Entry::getKey));
        Map.Entry<String, Object> entry;
        int len=paramList.size();
        for (int i=0;i<paramList.size();i++){
            entry = paramList.get(i);
            String key=entry.getKey();
            if (StringUtils.isNotBlank(key)){
                Object value = entry.getValue();
                if (encode){
                    //如果为true，进行编码
                    value= URLEncoder.encode(value.toString(),"UTF-8");
                }
                if((i-len)==-1){
                    stringBuffer.append(key).append("=").append(value);
                }else {
                    stringBuffer.append(key).append("=").append(value).append("&");
                }
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }




    public static void main(String[] args) {
        Map<String,Object> map=new HashMap<>();
        map.put("aello","你好");
        map.put("cold","eddad");
        map.put("bdwdwdw",1);
        String s = formatParameters(map, false);
        System.out.println(s);
    }
}
