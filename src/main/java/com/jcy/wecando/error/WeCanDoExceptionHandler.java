package com.jcy.wecando.error;

import com.jcy.wecando.error.exception.WeCanDoException;
import com.jcy.wecando.error.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class WeCanDoExceptionHandler {

    @ExceptionHandler(WeCanDoException.class)
    protected ResponseEntity<ErrorResponse> handlerExceptions(final WeCanDoException e) {
        log.error(e.getMessage());

        final ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(new ErrorResponse(errorCode.getCode(), errorCode.getMessage()),
                HttpStatus.valueOf(errorCode.getCode()));
    }
}