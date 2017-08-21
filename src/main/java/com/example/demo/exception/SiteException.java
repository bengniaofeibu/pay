package com.example.demo.exception;


import com.example.demo.enums.ResultEnum;

public class SiteException extends RuntimeException {
    private Integer code;

    public Integer getCode() {
        return code;
    }

    void setCode(Integer code) {
        this.code = code;
    }

    public SiteException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.setCode(resultEnum.getCode());
    }
}
