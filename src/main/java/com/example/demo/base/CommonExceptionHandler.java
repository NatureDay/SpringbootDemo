package com.example.demo.base;

import com.example.demo.util.LogUtil;
import com.example.demo.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 使用@ControllerAdvice注解的Controller层的全局异常统一处理
 */
@ControllerAdvice
public class CommonExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = CommonException.class)
    public Result exceptionHandler(CommonException exception) {
        LogUtil.error("-----------exceptionHandler: " + exception.toString());
        return ResultUtil.failure(exception.getCode(), exception.getMessage());
    }

}
