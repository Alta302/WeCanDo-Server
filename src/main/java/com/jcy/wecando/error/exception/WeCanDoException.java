package com.jcy.wecando.error.exception;

import lombok.Getter;

@Getter
public class WeCanDoException extends RuntimeException {

    private final ErrorCode errorCode;

    public WeCanDoException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public WeCanDoException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}