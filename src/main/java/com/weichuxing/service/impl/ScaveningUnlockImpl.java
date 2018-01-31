package com.weichuxing.service.impl;

import com.weichuxing.annotation.SystemServerLog;
import com.weichuxing.entity.WcxRequest.ScavengingUnlockRequest;
import com.weichuxing.entity.WcxResponse.ScavengingUnlockResponse;
import com.weichuxing.enums.WcxResultEnum;
import com.weichuxing.exception.LockException.SacveningUnlockException;
import com.weichuxing.mapper.WcxUserRegisterInfoMapper;
import com.weichuxing.model.TransRecordSupply;
import com.weichuxing.model.TransRecordTemp;
import com.weichuxing.model.UserInfo;
import com.weichuxing.model.WcxUserRegisterInfoRequest;
import com.weichuxing.service.ScaveningUnlockService;
import com.weichuxing.utils.HttpClient.HttpLockApiUtils;
import com.weichuxing.utils.common.Base64;
import com.weichuxing.utils.common.CommonUtils;
import io.swagger.models.auth.In;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class ScaveningUnlockImpl extends BaseServer implements ScaveningUnlockService{

    @Override
    @SystemServerLog(funcionExplain = "扫码开锁")
    public ScavengingUnlockResponse scavengingUnlock(ScavengingUnlockRequest scavengingUnlockRequest){

        ScavengingUnlockResponse scavengingUnlockResponse = new ScavengingUnlockResponse();
        String barcode = Base64.decode(scavengingUnlockRequest.getQrcode_content());
        String bicycleNo = CommonUtils.DecodeBarcode(barcode);
        String bikeInfo = HttpLockApiUtils.GetBikeInfoByBicycleNo(bicycleNo);
        if(!bikeInfo.equals("0")){
            JSONObject jsonBikeInfo = new JSONObject(bikeInfo);
            if(jsonBikeInfo.get("simNo") != null && jsonBikeInfo.get("cityNo") != null){
                String simNo = jsonBikeInfo.get("simNo").toString();
                String cityNo = jsonBikeInfo.get("cityNo").toString();
                Date borrowDateTime = new Date();
                long orderNum = System.currentTimeMillis() * 100 + CommonUtils.getRandom(100);

                WcxUserRegisterInfoRequest wcxUserRegisterInfoRequest =
                        wcxUserRegisterInfoMapper.selectByOpenId(scavengingUnlockRequest.getOpenId());
                if(wcxUserRegisterInfoRequest != null){
                    UserInfo userInfo = userInfoMapper.selectById(wcxUserRegisterInfoRequest.getUserId());
                    if(userInfo != null){
                        if(userInfo.getAccountStatus() == 3){
                            if(userInfo.getmBorrowBicycle() != 1){
                                int res = HttpLockApiUtils.OpenLock(simNo);
                                if(res == 1){
                                    //生成订单
                                    TransRecordTemp transRecordTemp = new TransRecordTemp();
                                    transRecordTemp.setBorrowBicycleNum(Integer.parseInt(bicycleNo));
                                    transRecordTemp.setId(scavengingUnlockRequest.getOrder_id());
                                    transRecordTemp.setBorrowBatteryNum(0);
                                    transRecordTemp.setBorrowDateTime(borrowDateTime);
                                    transRecordTemp.setOrderIntegral(0);
                                    transRecordTemp.setOrderNum(orderNum);
                                    transRecordTemp.setRecessionBatteryNum(0);
                                    transRecordTemp.setRecessionBicycleNum(0);
                                    transRecordTemp.setState(0);
                                    transRecordTemp.setTransFlag(2);
                                    transRecordTemp.setTransMoney(new BigDecimal(0));
                                    transRecordTemp.setBicycleType(0);
                                    transRecordTemp.setSimNo(simNo);
                                    transRecordTemp.setUseBlueTooth(0);
                                    transRecordTemp.setUserType(0);
                                    transRecordTemp.setCityNo(Integer.parseInt(cityNo));
                                    transRecordTemp.setUserId(wcxUserRegisterInfoRequest.getUserId());

                                    TransRecordSupply transRecordSupply = new TransRecordSupply();
                                    transRecordSupply.setTransId(scavengingUnlockRequest.getOrder_id());
                                    transRecordSupply.setDiscountMoney(new BigDecimal("0"));
                                    transRecordSupply.setFenceStatus(0);
                                    transRecordSupply.setOrderFrom("wcx");
                                    transRecordSupplyMapper.insert(transRecordSupply);
                                    transRecordTempMapper.insert(transRecordTemp);

                                    scavengingUnlockResponse.setBike_id(bicycleNo);
                                    scavengingUnlockResponse.setModel_id("5");
                                    scavengingUnlockResponse.setModel_type(3);

                                    return scavengingUnlockResponse;
                                }else{
                                    throw new SacveningUnlockException(WcxResultEnum.SCAVENING_UNLOCK_LOCKFAIL_ERROR);
                                }
                            }else{
                                throw new SacveningUnlockException(WcxResultEnum.SCAVENING_UNLOCK_ORDERNOTFINISH_ERROR);
                            }
                        }else{
                            throw new SacveningUnlockException(WcxResultEnum.INVALID_USER);
                        }

                    }else{
                        throw new SacveningUnlockException(WcxResultEnum.INVALID_USER);
                    }

                }else{
                    throw new SacveningUnlockException(WcxResultEnum.INVALID_USER);
                }
            }else{
                throw new SacveningUnlockException(WcxResultEnum.SCAVENING_UNLOCK_BICYCLENONOTFINISH);
            }
        }else{
            throw new SacveningUnlockException(WcxResultEnum.SCAVENING_UNLOCK_BICYCLENONOTFINISH);
        }
    }

}
