package com.jcy.wecando.error.exceptions;

import com.jcy.wecando.error.exception.WeCanDoException;
import com.jcy.wecando.error.exception.ErrorCode;

public class LoginFailedException extends WeCanDoException {
    public LoginFailedException() {
        super(ErrorCode.LOGIN_FAILED);
    }
}