package com.weichuxing.service.impl;

import com.weichuxing.enums.WcxEnum;
import com.weichuxing.model.WcxUserRegisterInfoRequest;
import com.weichuxing.service.DepositApplyService;
import com.weichuxing.utils.WcxResult;
import com.weichuxing.utils.WcxServiceUtil;
import com.weichuxing.utils.common.EncrypUtil;
import com.weichuxing.utils.common.Md5Util;
import com.weichuxing.utils.common.RequestValueUtils;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class DepositApplyServiceImpl extends BaseServer implements DepositApplyService {


    /**
     *申请押金退回
     * @param openid
     * @return
     */
    @Override
     public WcxResult applyDepositReturn(String openid, HttpServletRequest request) throws Exception {
        WcxUserRegisterInfoRequest wcxUserRegisterInfo = wcxUserRegisterInfoMapper.selectByOpenId(openid);
        Map<String,Object> reqMap=new HashMap<>();
        reqMap.put("userid",wcxUserRegisterInfo.getOpenid());
        reqMap.put("out_refund_no",generateDepositNum(100));
        reqMap.put("total_fee",wcxUserRegisterInfo.getDepositFee());
        reqMap.put("refund_fee",wcxUserRegisterInfo.getDepositFee());
        reqMap.put("userid_hash",wcxUserRegisterInfo.getUseridHash());
        reqMap.put("mobile_md5",Md5Util.MD5(wcxUserRegisterInfo.getUserMobile()));
        reqMap.put("client_ip",request.getRemoteAddr());
        String reqParam = RequestValueUtils.formatParameters(reqMap, false);

        Map<String,Object> reqInfoMap=new HashMap<>();
        String reqInfo =EncrypUtil.encrypt(reqParam,WcxServiceUtil.NONCE_STR);
        reqInfoMap.put("transaction_id",wcxUserRegisterInfo.getTransactionId());
        reqInfoMap.put("req_info", reqInfo);

        return  WcxServiceUtil.SendRequestToWcx(reqInfoMap, WcxEnum.RET_DEPOSIT_APPLY,WcxResult.class);
    }
}
