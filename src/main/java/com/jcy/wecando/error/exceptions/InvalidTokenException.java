package com.jcy.wecando.error.exceptions;

import com.jcy.wecando.error.exception.WeCanDoException;
import com.jcy.wecando.error.exception.ErrorCode;

public class InvalidTokenException extends WeCanDoException {
    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}