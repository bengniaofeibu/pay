package com.example.demo.handle;

import com.example.demo.entity.Result;
import com.example.demo.exception.BaseException;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {
    private Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof BaseException) {
            BaseException baseException = (BaseException) e;
            return ResultUtil.error(baseException.getCode(), baseException.getMessage());
        }
        else if(e instanceof MissingServletRequestParameterException){
            return ResultUtil.error(400, "参数错误");
        }
        else {
            logger.error("[Catch a exception] {}", e);
            return ResultUtil.error(-1, "Unknown error");
        }
    }
}
