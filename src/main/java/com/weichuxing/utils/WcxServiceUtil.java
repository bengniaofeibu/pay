package com.weichuxing.utils;

import com.weichuxing.entity.WcxRequest.BaseWcxRequest;
import com.weichuxing.enums.WcxEnum;
import com.weichuxing.enums.WcxResultEnum;
import com.weichuxing.exception.UserException.SignFailException;
import com.weichuxing.service.impl.BaseServer;
import com.weichuxing.utils.HttpClient.HttpSendUtils;
import com.weichuxing.utils.common.*;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public final class WcxServiceUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(WcxServiceUtil.class);

    private static final SimpleDateFormat DATA_FOMAT = new SimpleDateFormat("yyyy-MM-dd");


    // 运营平台 1：微信  2 ：QQ
    private static int OPERATEPLATFORM = 1;

    /**
     * 版本号
     **/
    private static final String VERSION = "1.0";

    /**
     * 随机串
     **/
    private static final String NONCE_STR = BaseUtil.getRandomUUID();

    /**
     * 腾讯财付通商户号(微信支付商户号)
     **/
    private static final String WX_SP_ID = "1461111202";

    /**
     * 腾讯财付通秘钥(可能为手Q支付商户号 ，也可能是微信支付商户号)
     **/
    private static final String WX_KEY = "43DBE8BC489BDC916DE00807BCB4B7D0";


    /**
     * 腾讯财付通商户号(可能为手Q支付商户号)
     **/
    private static final String QQ_SP_ID = "";

    private static final String QQ_KEY = "";

    private static String SP_ID = "";

    private static final Map<String, Object> BASE_PARAM = new HashMap<>();

    private static final List<String> NOT_SIGN_VALUE = Arrays.asList("sign", "key");


    @Autowired
    private HttpSendUtils httpSendUtils;

    @Autowired
    private BaseServer baseServer;

    static {
        BASE_PARAM.put("version", VERSION);
        BASE_PARAM.put("nonce_str", NONCE_STR);
        if (OPERATEPLATFORM == 1) {
            SP_ID = WX_SP_ID;
        } else {
            SP_ID = QQ_SP_ID;
        }
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

        final boolean isPlatform = isPlatform(valueMap);

        if (isPlatform) {
            valueMap.put("sp_id", WX_SP_ID);
        } else {
            valueMap.put("sp_id", QQ_SP_ID);
        }

        //格式话签名参数
        String params = RequestValueUtils.formatParameters(valueMap, false);
        StringBuffer buffer = new StringBuffer(params);

        if (isPlatform) {
            buffer.append("&").append("key").append("=").append(WX_KEY);
        } else {
            buffer.append("&").append("key").append("=").append(QQ_KEY);
        }
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
                Object o = field.get(baseWcxRequest);
                if (o != null) {
                    map.put(field.getName(), o);
                }
            }

            Class<?> superclass = tClass.getSuperclass();
            for (Field field : superclass.getDeclaredFields()) {
                if (!NOT_SIGN_VALUE.contains(field.getName())) {
                    field.setAccessible(true);
                    Object o = field.get(baseWcxRequest);
                    if (o != null) {
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
            Object value = entry.getValue();
            if (value != null) {
                if (res) {
                    //如果为true进行编码
                    valueEncoder = BaseUtil.getURLEncoder(value.toString());
                } else {
                    //如果为false进行解码
                    valueEncoder = BaseUtil.getURLDecode(value.toString());
                }
                map.put(entry.getKey(), valueEncoder);
            }
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
    public <T> T SendRequestToWcx(Map<String, Object> map, WcxEnum wcxEnum, Class<T> tClass) throws InvalidKeySpecException, NoSuchAlgorithmException {
        map.putAll(BASE_PARAM);
        //如果参数包含退押金的订单号，使用加密的nonce_str参数进行传输
        if (map.containsKey("out_refund_no")){
           map.put("nonce_str",baseServer.rsaEncrypt(map.get("nonce_str").toString(), RSAUtils.PRIVATE_KEY));
        }
        map.put("sign", generateSign(map));
        Map<String, Object> paramMap = getParamMapToEncoder(map, true);
        String res = httpSendUtils.sendRequest(paramMap, wcxEnum);
        LOGGER.debug("返回结果 {}", res);
        return (res == null || res.equals("")) ? null : getResponseToObject(res, tClass);
    }

    /**
     * 把放回值转成对应的实体bean
     *
     * @param result
     * @param tClass
     * @param <T>
     * @return
     */
    private <T> T getResponseToObject(String result, Class<T> tClass) {
        WcxResult wcxResult = JSON.parseObject(result, WcxResult.class);
        return WcxResult.parseToObject(wcxResult.getData(), tClass);
    }


    //判断是否哪个平台 微信：true  QQ ：false

    private static boolean isPlatform(Map<String, Object> map) {
        return WX_SP_ID.equals(map.get("sp_id"));
    }

    public static void main(String[] args) {

    }
}
