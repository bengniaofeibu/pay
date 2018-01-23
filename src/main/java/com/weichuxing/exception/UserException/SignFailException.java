package com.weichuxing.exception.UserException;

import com.weichuxing.enums.WcxResultEnum;
import com.weichuxing.exception.BaseException;

public class SignFailException extends BaseException {
    public SignFailException(WcxResultEnum userEnum) {
        super(userEnum.getCode(), userEnum.getMsg());
        this.setCode(userEnum.getCode());
    }
}
