package com.jcy.wecando.error.exceptions;

import com.jcy.wecando.error.exception.WeCanDoException;
import com.jcy.wecando.error.exception.ErrorCode;

public class AlreadySignedException extends WeCanDoException {
    public AlreadySignedException() {
        super(ErrorCode.ALREADY_USER_SIGNED);
    }
}