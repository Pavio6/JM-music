package com.jlf.music.common.exception;

import com.jlf.music.common.result.Result;
import com.jlf.music.common.result.ResultCodeEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 创建全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /*@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(ResultCodeEnum resultCodeEnum, Exception e) {
        e.printStackTrace();
        return Result.fail();
    }*/
    @ExceptionHandler(UserLoginException.class)
    @ResponseBody
    public ResponseEntity<ResultCodeEnum> handleCustomException(ResultCodeEnum resultCodeEnum, UserLoginException ex) {
        // 返回自定义异常的 ResultCodeEnum
        return new ResponseEntity<>(ex.getResultCode(), HttpStatus.valueOf(ex.getResultCode().getCode()));
    }
}

