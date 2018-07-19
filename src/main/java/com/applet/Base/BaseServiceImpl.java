package com.applet.Base;


import com.applet.Request.UserPayReq;
import com.applet.entity.ChinaPayBaseEntity;
import com.applet.entity.ChinaPaySinPayRes;
import com.applet.entity.PayBackStatusNotice;
import com.applet.enums.ChinaPayTranTypeEnums;
import com.applet.utils.HttpClient.HttpApiUtils;
import com.applet.utils.chinapayutils.SignUtil;
import com.applet.utils.common.Base64Util;
import com.applet.utils.common.JSONUtil;
import com.applet.utils.common.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public  abstract class BaseServiceImpl {

    @Autowired
    protected PayBackStatusNotice payBackStatusNotice;


    private static final Logger LOGGER= LoggerFactory.getLogger(BaseServiceImpl.class);

    @Value("${chinaPayTestResURL}")
    private String chinaPayTestResURL;

    @Value("${chinaPayBackURL}")
    private String chinaPayBackURL;

    @Value("${chinaPaySinPay}")
    private String chinaPaySinPay;

    @Value("${splitMerInfo}")
    private String splitMerInfo;

    @Autowired
    private RedisUtil redisUtil;

    protected static final String RES_CODE ="0000";

    protected static final String CHINA_PAY_RES_CODE ="0014";

    private static final String REMOTE_IP="10.0.180.54";

    private static final String SPLIT_TYPE="0001";

    private static final String SPLIT_METHOD="0";

    public static final String USER_PAY_SUBJECT = "user:pay:subject:";




    //生成请求参数
    protected Map getBaseReqMap(ChinaPayBaseEntity chinaPayBaseEntity,ChinaPayTranTypeEnums chinaPayTranTypeEnums){
        Map sendMap=new HashMap();


        String tranType = chinaPayTranTypeEnums.getTranType();
        switch (tranType){
            case "0504":
            case "0505":
            sendMap.put("OriTranType",chinaPayBaseEntity.getOriTranType());
            break;
            case "0608":
            case "9904":
            case "9905":
            case "0606":
            case "0004":
            sendMap.put("MerOrderNo", chinaPayBaseEntity.getMerOrderNo());
            sendMap.put("TranDate",chinaPayBaseEntity.getTranDate());
            sendMap.put("TranTime",chinaPayBaseEntity.getTranTime());
            break;
        }

        switch (tranType){
            case "9904":
            case "0004":
                sendMap.put("MerBgUrl",chinaPayBackURL);
                break;
            case "0606":
             sendMap.put("OrderAmt",chinaPayBaseEntity.getOrderAmt());
//                sendMap.put("OrderAmt","1000");
             break;
        }


        switch (tranType){
            case "0004":
            sendMap.put("OrderAmt",chinaPayBaseEntity.getOrderAmt());
            sendMap.put("SplitType",chinaPayBaseEntity.getSplitType() == null?SPLIT_TYPE:chinaPayBaseEntity.getSplitType());
            sendMap.put("SplitMethod",chinaPayBaseEntity.getSplitMethod() == null?SPLIT_METHOD:chinaPayBaseEntity.getSplitMethod());
            sendMap.put("MerSplitMsg",getSplitMerInfo(splitMerInfo,chinaPayBaseEntity.getAmounts()));
            sendMap.put("RemoteAddr",REMOTE_IP);
            break;
        }

        sendMap.put("Version",chinaPayBaseEntity.getVersion());
        sendMap.put("MerId",chinaPayBaseEntity.getMerId());
        sendMap.put("BusiType",chinaPayBaseEntity.getBusiType());
        sendMap.put("TranType", tranType);
        sendMap.put("CardTranData", SignUtil.encryptData(Base64Util.encode(chinaPayBaseEntity.getCardTranDataEncryptData())));
        sendMap.put("Signature", SignUtil.sign(sendMap));
        return sendMap;
    }



    protected Map<String,String> getSendRes(Map sendMap){
        Map<String,String> resMap = HttpApiUtils.sendRequestToChinaPay(chinaPayTestResURL, (Map<String, Object>) sendMap);

        if (resMap!=null && resMap.size()>0){
            String respMsg= null;
            try {
                respMsg = URLDecoder.decode(resMap.get("respMsg"),"UTF-8");
            } catch (UnsupportedEncodingException e) {
                LOGGER.error("ERROR {}",e);
            }
                LOGGER.error(" respCode {} respMsg {}", resMap.get("respCode"),respMsg);
                resMap.put("respMsg",respMsg);
                return resMap;
        }
        return null;
      }


    protected Map<String,String> getSendChinaSinPayRes(Map sendMap){
        Map<String,String> resMap = HttpApiUtils.sendRequestToChinaPay(chinaPaySinPay, (Map<String, Object>) sendMap);

        if (resMap!=null && resMap.size()>0){
            ChinaPaySinPayRes chinaPaySinPayRes=JSONUtil.parseObject(JSONUtil.toJSONString(resMap), ChinaPaySinPayRes.class);

        }
        return null;
    }



    //获取分账信息
    private  static String getSplitMerInfo(String splitMerInfo,String amounts[]){
        String[] splitInfo = splitMerInfo.split(";");
        LOGGER.debug("splitInfo {}",JSONUtil.toJSONString(splitInfo));

        StringBuilder splitBuild=new StringBuilder();
        int len=splitInfo.length;
        for (int i=0;i<len;i++){
            String split = splitInfo[i];
            String amount = amounts[i];
                if ((i-len)==-1){
                    splitBuild.append(split).append("^").append(amount);
                }else {
                    splitBuild.append(split).append("^").append(amount).append(";");
                }
        }
        return splitBuild.toString();
    }

    //记录用户该订单标题，用来区分支付回调业务场景
    protected void recordUserPaySubject(UserPayReq userPayReq){
        redisUtil.setObj(USER_PAY_SUBJECT+userPayReq.getOrderNumber(),userPayReq.getOrderSubject());
    }
}
