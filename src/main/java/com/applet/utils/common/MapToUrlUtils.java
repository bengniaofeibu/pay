package com.applet.utils.common;

import org.apache.commons.lang3.StringUtils;

import java.net.URLEncoder;
import java.util.*;

public class MapToUrlUtils {

	
	 /**
	 * @param paraMap
	 * @param urlEncode
	 * @param keyToLower
	 * @return
	 */
	public static String formatUrlMap(Map<String,String> paraMap, boolean urlEncode, boolean keyToLower)
	   {  
	       String buff;
	       Map<String, String> tmpMap = paraMap;
	       try  
	       {  
	           List<Map.Entry<String, String>> infoIds = new ArrayList<>(tmpMap.entrySet());
	           // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）  
	           Collections.sort(infoIds, Comparator.comparing(Map.Entry::getKey));
	           // 构造URL 键值对的格式  
	           StringBuilder buf = new StringBuilder();  
	           for (Map.Entry<String, String> item : infoIds)
	           {  
	               if (StringUtils.isNotBlank(item.getKey()))
	               {  
	                   String key = item.getKey();  
	                   String val = item.getValue();
	                   if (urlEncode)  
	                   {  
	                       val = URLEncoder.encode(val, "utf-8");
	                   }  
	                   if (keyToLower)  
	                   {  
	                       buf.append(key.toLowerCase() + "=" + val);  
	                   } else  
	                   {  
	                       buf.append(key + "=" + val);  
	                   }  
	                   buf.append("&");  
	               }  
	  
	           }  
	           buff = buf.toString();  
	           if (buff.isEmpty() == false)  
	           {  
	               buff = buff.substring(0, buff.length() - 1);  
	           }  
	       } catch (Exception e)  
	       {  
	          return null;  
	       }  
	       return buff;  
	   }  
}
