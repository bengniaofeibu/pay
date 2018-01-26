package com.weichuxing.utils;

import com.weichuxing.entity.WcxRequest.BaseWcxRequest;
import com.weichuxing.enums.WcxEnum;
import com.weichuxing.enums.WcxResultEnum;
import com.weichuxing.exception.UserException.SignFailException;
import com.weichuxing.utils.HttpClient.HttpSendUtils;
import com.weichuxing.utils.common.*;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.*;

@Component
public final class WcxServiceUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(WcxServiceUtil.class);

    /**
     * 版本号
     **/
    private static final String VERSION = "1.0";

    /**
     * 随机串
     **/
    private static final String NONCE_STR = BaseUtil.getRandomUUID();

    /**
     * 腾讯财付通商户号(可能为手Q支付商户号 ，也可能是微信支付商户号)
     **/
    private static final String SP_ID = "1461111202";

    /**
     * 腾讯财付通秘钥(可能为手Q支付商户号 ，也可能是微信支付商户号)
     **/
    private static final String key = "43DBE8BC489BDC916DE00807BCB4B7D0";

    private static final Map<String, Object> BASE_PARAM = new HashMap<>();

    private static final List<String> NOT_SIGN_VALUE=Arrays.asList("sign","key");


    @Autowired
    private HttpSendUtils httpSendUtils;

    static {
        BASE_PARAM.put("version", VERSION);
        BASE_PARAM.put("nonce_str", NONCE_STR);
        BASE_PARAM.put("sp_id", SP_ID);
    }


    /**
     * 生成签名
     *
     * @return
     */
    private static String generateSign(Map<String, Object> valueMap) {

        if (!valueMap.containsKey(SP_ID)) {
            valueMap.putAll(BASE_PARAM);
        }
        //格式话签名参数
        String params = RequestValueUtils.formatParameters(valueMap, false);
        StringBuffer buffer = new StringBuffer(params);
        buffer.append("&").append("key").append("=").append(key);
        return Md5Util.MD5(buffer.toString());
    }


    /**
     * 生成验证签名的map
     *
     * @return
     * @throws SignFailException
     * @throws IllegalAccessException
     */
    private static Map<String, Object> generateSignMap(BaseWcxRequest baseWcxRequest) {
        Map<String, Object> map = new HashMap<>();
        Class<? extends BaseWcxRequest> tClass = baseWcxRequest.getClass();
        try {
            for (Field field : tClass.getDeclaredFields()) {
                field.setAccessible(true);
                Object o =field.get(baseWcxRequest);
                if (o!=null){
                    map.put(field.getName(), o);
                }
            }

            Class<?> superclass = tClass.getSuperclass();
            for (Field field : superclass.getDeclaredFields()) {
                if (!NOT_SIGN_VALUE.contains(field.getName())){
                    field.setAccessible(true);
                   Object o = field.get(baseWcxRequest);
                   if (o!=null){
                       map.put(field.getName(), o);
                   }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 验证签名
     *
     * @param baseWcxRequest
     */
    public void verificationSign(BaseWcxRequest baseWcxRequest) {
        String sign = generateSign(generateSignMap(baseWcxRequest));
        if (!sign.equals(baseWcxRequest.getSign())) {
            throw new SignFailException(WcxResultEnum.SIGN_FAIL);
        }
    }


    /**
     * 对所以参数进行Encoder
     *
     * @param paramMap
     * @return
     */
    public static Map<String, Object> getParamMapToEncoder(Map<String, Object> paramMap, boolean res) {
        Map<String, Object> map = new LinkedHashMap<>();
        String valueEncoder;
        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            if (res) {
                //如果为true进行编码
                valueEncoder = BaseUtil.getURLEncoder(entry.getValue().toString());
            } else {
                //如果为false进行解码
                valueEncoder = BaseUtil.getURLDecode(entry.getValue().toString());
            }
            map.put(entry.getKey(), valueEncoder);
        }
        return map;
    }

    /**
     * 请求微出行接口公共请求方式
     *
     * @param map
     * @param wcxEnum
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> T SendRequestToWcx(Map<String, Object> map, WcxEnum wcxEnum, Class<T> tClass) {
        BASE_PARAM.putAll(map);
        BASE_PARAM.put("sign", generateSign(map));
        Map<String, Object> paramMap = getParamMapToEncoder(BASE_PARAM, true);
        String res = httpSendUtils.sendRequest(paramMap, wcxEnum);
        WcxResult wcxResult = JSON.parseObject(res, WcxResult.class);
        LOGGER.debug("返回结果 {}", res);
        return WcxResult.parseToObject(wcxResult.getData(), tClass);
    }
    public static void main(String[] args) {
    }
}
