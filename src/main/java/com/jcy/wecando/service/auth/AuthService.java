package com.jcy.wecando.service.auth;

import com.jcy.wecando.payload.request.SignInRequest;
import com.jcy.wecando.payload.response.TokenResponse;

public interface AuthService {
    TokenResponse signIn(SignInRequest signInRequest);
    TokenResponse refreshToken(String refreshToken);
    void logout(String token, String deviceToken);
}