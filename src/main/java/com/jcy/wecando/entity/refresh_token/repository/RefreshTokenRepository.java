package com.jcy.wecando.entity.refresh_token.repository;

import com.jcy.wecando.entity.refresh_token.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
    Optional<RefreshToken> findByRefreshToken(String refreshToken);
    void deleteAllById(Long id);
}