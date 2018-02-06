package com.applet.utils.HttpClient;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HttpLockApiUtils {

    public static String GetBikeInfoByBicycleNo(String bicycleNo){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("bicycleNo", bicycleNo);

        JSONObject backResult;
        try {
            backResult = new JSONObject(HttpApiUtils.getBikeInfo(params));
            String code = backResult.get("code").toString();
            if(code.equals("0")){
                String bikeInfo = backResult.get("bikeInfo").toString();
                return bikeInfo;
            }else{
                return "0";
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return "0";
        }
    }

    public static int OpenLock(String simNo){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("simNo", simNo);

        JSONObject backResult;
        try {
            backResult = new JSONObject(HttpApiUtils.openLock(params));
            String code = backResult.get("code").toString();
            if(code.equals("1")){
                return 1;
            }else{
                return 0;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
