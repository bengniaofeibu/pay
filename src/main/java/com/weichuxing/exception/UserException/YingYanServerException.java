package com.weichuxing.exception.UserException;

import com.weichuxing.enums.WcxResultEnum;
import com.weichuxing.exception.BaseException;

public class YingYanServerException extends BaseException {
    public YingYanServerException(WcxResultEnum wcxResultEnum) {
        super(wcxResultEnum.getCode(), wcxResultEnum.getMsg());
        this.setCode(wcxResultEnum.getCode());
    }
}
