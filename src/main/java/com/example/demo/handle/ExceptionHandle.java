package com.example.demo.handle;

import com.example.demo.entity.Result;
import com.example.demo.exception.SiteException;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof SiteException) {
            SiteException siteException = (SiteException) e;
            return ResultUtil.error(siteException.getCode(), siteException.getMessage());
        } else {
            logger.error("[系统异常] {}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}