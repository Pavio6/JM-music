package com.jlf.music.common.exception;

import com.jlf.music.common.result.ResultCodeEnum;

public class UserLoginException extends RuntimeException {
    private final ResultCodeEnum resultCode;
    public UserLoginException(ResultCodeEnum resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }
    public ResultCodeEnum getResultCode() {
        return resultCode;
    }
}


