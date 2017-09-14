package com.example.demo.exception;


public class BaseException extends RuntimeException {
    private Integer code;

    public Integer getCode() {
        return code;
    }

    void setCode(Integer code) {
        this.code = code;
    }

    public BaseException(Integer code, String msg) {
        super(msg);
        this.setCode(code);
    }
}
