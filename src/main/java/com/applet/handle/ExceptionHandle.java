package com.applet.handle;

import com.applet.enums.ResultEnums;
import com.applet.utils.AppletResult;
import com.applet.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {
    private Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public AppletResult handle(Exception e) {
            logger.error("[Catch a exception] {}",e);
            return ResultUtil.error(ResultEnums.SERVER_ERROR);
    }
}
