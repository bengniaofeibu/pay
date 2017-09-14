package com.example.demo.exception;

import com.example.demo.enums.UserEnum;

public class UserException extends BaseException {
    public UserException(UserEnum userEnum) {
        super(userEnum.getCode(), userEnum.getMsg());
        this.setCode(userEnum.getCode());
    }
}
