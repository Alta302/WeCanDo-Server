package com.jcy.wecando.payload.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {
    private String name;
}