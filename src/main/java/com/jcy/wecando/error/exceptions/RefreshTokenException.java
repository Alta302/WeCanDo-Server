package com.jcy.wecando.error.exceptions;

import com.jcy.wecando.error.exception.WeCanDoException;
import com.jcy.wecando.error.exception.ErrorCode;

public class RefreshTokenException extends WeCanDoException {
    public RefreshTokenException() {
        super(ErrorCode.REFRESH_TOKEN_FAILED);
    }
}