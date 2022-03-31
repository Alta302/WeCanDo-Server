package com.jcy.wecando.payload.request;

import lombok.Getter;

@Getter
public class SignInRequest {
    private Long id;
    private String password;
}