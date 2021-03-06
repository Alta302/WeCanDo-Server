package com.jcy.wecando.entity.refresh_token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken {
    @Id
    private String refreshToken;

    private Long id;

    public RefreshToken updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;

        return this;
    }
}