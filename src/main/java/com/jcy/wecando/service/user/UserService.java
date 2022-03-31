package com.jcy.wecando.service.user;

import com.jcy.wecando.payload.request.SignUpRequest;
import com.jcy.wecando.payload.response.UserResponse;

public interface UserService {
    void signUp(SignUpRequest signUpRequest);
    UserResponse getMyInfo(String token);
    void updateIsNotificationComment(String token, Boolean isNotificationComment);
}