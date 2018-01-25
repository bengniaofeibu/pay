package com.weichuxing.exception.UserException;

import com.weichuxing.enums.WcxResultEnum;
import com.weichuxing.exception.BaseException;

public class InvalidUserException extends BaseException {
    public InvalidUserException(WcxResultEnum userEnum) {
        super(userEnum.getCode(), userEnum.getMsg());
        this.setCode(userEnum.getCode());
    }
}
