package com.weichuxing.exception.LockException;

import com.weichuxing.enums.WcxResultEnum;
import com.weichuxing.exception.BaseException;

public class SacveningUnlockException extends BaseException{

    public SacveningUnlockException(WcxResultEnum wcxResultEnum) {
        super(wcxResultEnum.getCode(), wcxResultEnum.getMsg());
        this.setCode(wcxResultEnum.getCode());
    }
}
