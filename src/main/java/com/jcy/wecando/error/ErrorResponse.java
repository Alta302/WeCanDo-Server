package com.jcy.wecando.error;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {
    private int status;
    private String message;
}
