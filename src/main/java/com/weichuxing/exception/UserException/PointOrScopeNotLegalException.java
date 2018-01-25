package com.weichuxing.exception.UserException;

import com.weichuxing.enums.WcxResultEnum;
import com.weichuxing.exception.BaseException;

public class PointOrScopeNotLegalException extends BaseException{

    public PointOrScopeNotLegalException(WcxResultEnum wcxResultEnum) {
        super(wcxResultEnum.getCode(), wcxResultEnum.getMsg());
        this.setCode(wcxResultEnum.getCode());
    }
}
