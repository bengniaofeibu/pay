package com.applet.service.impl;

import com.applet.Base.BaseServiceImpl;
import com.applet.annotation.SystemServerLog;
import com.applet.entity.ChinaPayBaseEntity;
import com.applet.entity.ChinaPaySinPayReq;
import com.applet.enums.ChinaPayTranTypeEnums;
import com.applet.enums.ResultEnums;
import com.applet.mapper.ChinaPayOrderInfoMapper;
import com.applet.mapper.CustomerOrderInfoMapper;
import com.applet.model.ChinaPayOrderInfo;
import com.applet.model.CustomerOrderInfo;
import com.applet.service.ChinaPayService;
import com.applet.utils.AppletResult;
import com.applet.utils.ResultUtil;
import com.applet.utils.common.JSONUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.runtime.Log;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.Map;

@Service
public class ChinaPayServiceImpl extends BaseServiceImpl implements ChinaPayService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChinaPayServiceImpl.class);

    @Autowired
    private ChinaPayOrderInfoMapper chinaPayOrderInfoMapper;

    @Autowired
    private CustomerOrderInfoMapper customerOrderInfoMapper;

    private static final String CHINA_PAY_RETURN_CODE="200";



    /**
     * 签约查询
     *
     * @param chinaPayBaseEntity
     * @return
     */
    @SystemServerLog(funcionExplain = "签约查询")
    @Override
    public AppletResult signgingAndQuery(ChinaPayBaseEntity chinaPayBaseEntity){
        return returnResult(chinaPayBaseEntity,ChinaPayTranTypeEnums.SIGINING_AND_QUERY,ResultEnums.CHINA_SIGNING_QUERY_FAIL,"SignState");
    }

    /**
     * 交易要素查询
     *
     * @param chinaPayBaseEntity
     * @return
     */
    @SystemServerLog(funcionExplain = "交易要素查询")
    @Override
    public AppletResult tradingElementsQuery(ChinaPayBaseEntity chinaPayBaseEntity){



//        //请求map
        Map sendMap = getBaseReqMap(chinaPayBaseEntity, ChinaPayTranTypeEnums.TRADING_ELEMENTS_QUERY);
        LOGGER.debug("交易要素查询请求参数 {}",sendMap);

        if (sendMap != null) {
//            TradingElementsQueryResEntity reqEntity = getSendRes(sendMap, TradingElementsQueryResEntity.class);
          Map map=  getSendRes(sendMap);
        String aa= (String)map.get("TransExtField");
            try {
                System.out.println(URLDecoder.decode(aa,"UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
//            if (reqEntity != null && reqEntity.getRespCode() == 0000) {
//                return ResultUtil.success(SignUtil.decryptData(reqEntity.getTransExfield()));
//            }
        }
        return ResultUtil.error(ResultEnums.CHINA_TRADING_ELEMENTS_QUERY_FAIL);
    }

    /**
     * 签约短信
     *
     * @param chinaPayBaseEntity
     * @return
     */
    @SystemServerLog(funcionExplain = "签约短信")
    @Override
    public AppletResult signingSms(ChinaPayBaseEntity chinaPayBaseEntity){
        return returnResult(chinaPayBaseEntity,ChinaPayTranTypeEnums.SIGINING_SMS, ResultEnums.CHINA_SIGNING_SMS_FAIL, "");
    }

    /**
     * 签约接口
     *
     * @param chinaPayBaseEntity
     * @return
     */
    @SystemServerLog(funcionExplain = "签约")
    @Override
    public AppletResult signing(ChinaPayBaseEntity chinaPayBaseEntity){
        return returnResult(chinaPayBaseEntity,ChinaPayTranTypeEnums.SIGINING,ResultEnums.CHINA_SIGNING_FAIL,"SignState");
    }

    /**
     * 解约接口
     *
     * @param chinaPayBaseEntity
     * @return
     */
    @Override
    public AppletResult unSigning(ChinaPayBaseEntity chinaPayBaseEntity) {
        return returnResult(chinaPayBaseEntity,ChinaPayTranTypeEnums.UNSIGINING,ResultEnums.CHINA_UNSIGNING_FAIL,"SignState");
    }

    /**
     * 支付短信
     *
     * @param chinaPayBaseEntity
     * @return
     */
    @SystemServerLog(funcionExplain = "支付短信")
    @Override
    public AppletResult paySms(ChinaPayBaseEntity chinaPayBaseEntity) {
        return returnResult(chinaPayBaseEntity,ChinaPayTranTypeEnums.PAY_SMS,ResultEnums.CHINA_PAY_SMS_FAIL,"");
    }

    /**
     * 支付
     *
     * @param chinaPayBaseEntity
     * @return
     */
    @SystemServerLog(funcionExplain = "支付")
    @Override
    public AppletResult chinaPay(ChinaPayBaseEntity chinaPayBaseEntity) {
       return returnResult(chinaPayBaseEntity,ChinaPayTranTypeEnums.CHINA_PAY,ResultEnums.CHINA_PAY_FAIL,"");
    }

    /**
     * 银联支付回调
     *
     * @param chinaPayBaseEntity
     * @return
     */
    @SystemServerLog(funcionExplain = "银联支付回调")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String chinaPayBack(ChinaPayBaseEntity chinaPayBaseEntity) {

      LOGGER.debug("chinaPayBaseEntity {}",JSONUtil.toJSONString(chinaPayBaseEntity));

        ChinaPayOrderInfo chinaPayOrderInfo=new ChinaPayOrderInfo();
        chinaPayOrderInfo.setOrderNumber(chinaPayBaseEntity.getMerOrderNo());
        chinaPayOrderInfo.setOrderStatus(chinaPayBaseEntity.getOrderStatus());
        chinaPayOrderInfo.setSplitType(chinaPayBaseEntity.getSplitType());
        chinaPayOrderInfo.setSplitMethod(Short.valueOf(chinaPayBaseEntity.getSplitMethod()));
        try {
          String merSplitMsg = URLDecoder.decode(chinaPayBaseEntity.getMerSplitMsg(),"UTF-8")  ;
          chinaPayOrderInfo.setMerSplitMsg(merSplitMsg);
        } catch (UnsupportedEncodingException e) {
           LOGGER.error(" URLDecoder ERROR {}",e);
        }
        chinaPayOrderInfo.setBankInstNo(chinaPayBaseEntity.getBankInstNo());
        chinaPayOrderInfo.setAcqSeqId(chinaPayBaseEntity.getAcqSeqId());
        chinaPayOrderInfo.setAcqDate(chinaPayBaseEntity.getAcqDate());
        chinaPayOrderInfo.setChannelSeqId(chinaPayBaseEntity.getChannelSeqId());
        chinaPayOrderInfo.setChannelDate(chinaPayBaseEntity.getChannelDate());
        chinaPayOrderInfo.setChannelTime(chinaPayBaseEntity.getChannelTime());
        chinaPayOrderInfo.setCompleteDate(chinaPayBaseEntity.getCompleteDate());
        chinaPayOrderInfo.setCompleteTime(chinaPayBaseEntity.getCompleteTime());
       int insertCount= chinaPayOrderInfoMapper.insertChinaPayInfo(chinaPayOrderInfo);


        CustomerOrderInfo customerOrderInfo=new CustomerOrderInfo();
        customerOrderInfo.setOrderNumber(chinaPayBaseEntity.getMerOrderNo());
        customerOrderInfo.setTotalAmount(new BigDecimal(chinaPayBaseEntity.getOrderAmt()));
        customerOrderInfo.setTradeNo(chinaPayBaseEntity.getAcqSeqId());
        customerOrderInfo.setPayStatus((short) 2);
        customerOrderInfo.setPayWay((short) 3);
        int updateCount = customerOrderInfoMapper.updateOrderStatusByOrderNum(customerOrderInfo);
        LOGGER.debug(" 银联支付回调 插入数量 {}  更新用户状态数量 --> {}", insertCount,updateCount);


        return CHINA_PAY_RETURN_CODE;
    }

    /**
     * 银联单笔代付
     *
     * @param chinaPaySinPay
     * @return
     */
    @SystemServerLog(funcionExplain = "银联单笔代付")
    @Override
    public AppletResult chinaPaySinPay(ChinaPaySinPayReq chinaPaySinPay) {
//
//         Map<String,String> sendMap= JSONUtil.objectToMap(chinaPaySinPay.getChinaPaySinPay());
//         LOGGER.debug("银联代付请求参数 {}",JSONUtil.toJSONString(sendMap));
//
//        getSendChinaSinPayRes(sendMap);

        return ResultUtil.success();
    }


    //获取返回值
    private AppletResult returnResult(ChinaPayBaseEntity chinaPayBaseEntity,ChinaPayTranTypeEnums chinaPayTranTypeEnums,ResultEnums resultEnums,String paramName){

        Map sendMap = getBaseReqMap(chinaPayBaseEntity, chinaPayTranTypeEnums);
        LOGGER.debug("银联请求参数 {}",sendMap);

        Map<String,String> map= getSendRes(sendMap);

        if (map == null){
            return  ResultUtil.error(ResultEnums.CHINA_SERVER_ERROR);
        }

          String respCode=  map.get("respCode");
          String respMsg=map.get("respMsg");
        if (!RES_CODE.equals(respCode) && !CHINA_PAY_RES_CODE.equals(respCode) ){
            return  ResultUtil.error(resultEnums,respMsg);
        }

        if (StringUtils.isBlank(paramName)){
            return  ResultUtil.success();
        }

        String value=map.get(paramName);
        if (value == null){
            return ResultUtil.success(paramName);
        }
        return ResultUtil.success(value);
    }
}