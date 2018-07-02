package com.applet.service;

import com.applet.entity.ChinaPayBaseEntity;
import com.applet.entity.ChinaPaySinPayReq;
import com.applet.utils.AppletResult;

public interface ChinaPayService {


    /**
     * 签约查询
     * @param chinaPayBaseEntity
     * @return
     */
    AppletResult signgingAndQuery(ChinaPayBaseEntity chinaPayBaseEntity);


    /**
     * 签约要素
     * @param chinaPayBaseEntity
     * @return
     */
    AppletResult tradingElementsQuery(ChinaPayBaseEntity chinaPayBaseEntity);


    /**
     *
     * 签约短信
     * @param chinaPayBaseEntity
     * @return
     */
    AppletResult signingSms(ChinaPayBaseEntity chinaPayBaseEntity);


    /**
     *
     * 签约接口
     * @param chinaPayBaseEntity
     * @return
     */
    AppletResult signing(ChinaPayBaseEntity chinaPayBaseEntity);


    /**
     *
     *  解约接口
     * @param chinaPayBaseEntity
     * @return
     */
    AppletResult unSigning(ChinaPayBaseEntity chinaPayBaseEntity);


    /**
     *
     * 支付短信
     * @param chinaPayBaseEntity
     * @return
     */
    AppletResult paySms(ChinaPayBaseEntity chinaPayBaseEntity);


    /**
     *
     * 支付
     * @param chinaPayBaseEntity
     * @return
     */
    AppletResult chinaPay(ChinaPayBaseEntity chinaPayBaseEntity);

    /**
     * 银联支付回调
     * @param chinaPayBaseEntity
     * @return
     */
    String chinaPayBack(ChinaPayBaseEntity chinaPayBaseEntity);


    /**
     * 银联单笔代付
     * @param chinaPaySinPay
     * @return
     */
    AppletResult chinaPaySinPay(ChinaPaySinPayReq chinaPaySinPay);

}
