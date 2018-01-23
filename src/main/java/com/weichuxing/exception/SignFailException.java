package com.weichuxing.exception;

import com.weichuxing.enums.WcxResultEnum;

public class SignFailException extends BaseException {
    public SignFailException(WcxResultEnum userEnum) {
        super(userEnum.getCode(), userEnum.getMsg());
        this.setCode(userEnum.getCode());
    }
}
