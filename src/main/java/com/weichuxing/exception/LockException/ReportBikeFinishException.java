package com.weichuxing.exception.LockException;

import com.weichuxing.enums.WcxResultEnum;
import com.weichuxing.exception.BaseException;

public class ReportBikeFinishException extends BaseException{

    public ReportBikeFinishException(WcxResultEnum wcxResultEnum) {
        super(wcxResultEnum.getCode(), wcxResultEnum.getMsg());
        this.setCode(wcxResultEnum.getCode());
    }

}
