package com.weichuxing.handle;

import com.weichuxing.exception.BaseException;
import com.weichuxing.utils.ResultUtil;
import com.weichuxing.utils.WcxResult;
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
    public WcxResult handle(Exception e) {
        if (e instanceof BaseException) {
            BaseException baseException = (BaseException) e;
            return ResultUtil.error(baseException.getCode(), baseException.getMessage());
        }
        else if(e instanceof MissingServletRequestParameterException){
            return ResultUtil.error(1000, "无效的参数");
        }
        else {
            logger.error("[Catch a exception] {}", e);
            return ResultUtil.error(-1, "系统错误");
        }
    }
}
