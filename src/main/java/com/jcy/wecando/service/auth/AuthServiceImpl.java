package com.jcy.wecando.service.auth;

import com.jcy.wecando.entity.refresh_token.RefreshToken;
import com.jcy.wecando.entity.refresh_token.repository.RefreshTokenRepository;
import com.jcy.wecando.entity.user.User;
import com.jcy.wecando.entity.user.repository.UserRepository;
import com.jcy.wecando.error.exceptions.InvalidTokenException;
import com.jcy.wecando.error.exceptions.LoginFailedException;
import com.jcy.wecando.error.exceptions.RefreshTokenException;
import com.jcy.wecando.error.exceptions.UserNotFoundException;
import com.jcy.wecando.payload.request.SignInRequest;
import com.jcy.wecando.payload.response.TokenResponse;
import com.jcy.wecando.util.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    private final JwtProvider jwtProvider;

    @Override
    public TokenResponse signIn(SignInRequest signInRequest) {
        return userRepository.findById(signInRequest.getId())
                .map(user -> {

                    userRepository.save(user);

                    String accessToken = jwtProvider.generateAccessToken(signInRequest.getId());
                    String refreshToken = jwtProvider.generateRefreshToken(signInRequest.getId());

                    refreshTokenRepository.save(
                            RefreshToken.builder()
                                    .id(user.getId())
                                    .refreshToken(refreshToken)
                                    .build()
                    );

                    return TokenResponse.builder()
                            .accessToken(accessToken)
                            .refreshToken(refreshToken)
                            .build();
                })
                .orElseThrow(LoginFailedException::new);
    }

    @Override
    public TokenResponse refreshToken(String refreshToken) {
        if (!jwtProvider.isRefreshToken(refreshToken) || !jwtProvider.validateToken(refreshToken))
            throw new InvalidTokenException();

        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .map(refreshToken1 -> {
                    String newAccessToken = jwtProvider.generateAccessToken(refreshToken1.getId());
                    String newRefreshToken = jwtProvider.generateRefreshToken(refreshToken1.getId());

                    refreshTokenRepository.save(refreshToken1.updateRefreshToken(newRefreshToken));

                    return TokenResponse.builder()
                            .accessToken(newAccessToken)
                            .refreshToken(newRefreshToken)
                            .build();
                })
                .orElseThrow(RefreshTokenException::new);
    }

    @Override
    @Transactional
    public void logout(String token, String deviceToken) {
        User user = userRepository.findById(jwtProvider.getId(token))
                .orElseThrow(UserNotFoundException::new);
    }
}