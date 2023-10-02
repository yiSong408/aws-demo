package com.rongyi.untils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public <T> ResultAjax<T> exceptionHandler(Exception e){
        if(e instanceof AppException){
           AppException appException = (AppException) e;
           return ResultAjax.error(appException.getCode(),appException.getMsg());
        }
        return ResultAjax.error(500,"unexpected problem happened");
    }
}
