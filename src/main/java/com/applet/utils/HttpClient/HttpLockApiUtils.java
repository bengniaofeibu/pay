package com.applet.utils.HttpClient;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HttpLockApiUtils {

    public static JSONObject GetBikeInfoByBicycleNo(String bicycleNo){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("bicycleNo", bicycleNo);

        JSONObject backResult;
        try {
            backResult = new JSONObject(HttpApiUtils.getBikeInfos(params));
            String code = backResult.get("code").toString();
            if(code.equals("0")){
                return backResult;
            }else{
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int OpenLockBySms(String iccid){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("iccid", iccid);
        params.put("orderType", 1);

        JSONObject backResult;
        try {
            backResult = new JSONObject(HttpApiUtils.openLockBySms(params));
            String result = backResult.get("result").toString();
            if(result.equals("ok")){
                return 1;
            }else{
                return 0;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int OpenLockByGprs(String simNo){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("simNo", simNo);

        JSONObject backResult;
        try {
            backResult = new JSONObject(HttpApiUtils.openLockByGprs(params));
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
