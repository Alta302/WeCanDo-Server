package com.jcy.wecando.error.exceptions;

import com.jcy.wecando.error.exception.WeCanDoException;
import com.jcy.wecando.error.exception.ErrorCode;

public class UserNotFoundException extends WeCanDoException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}