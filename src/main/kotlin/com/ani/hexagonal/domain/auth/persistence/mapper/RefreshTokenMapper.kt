package com.ani.hexagonal.domain.auth.persistence.mapper

import com.ani.hexagonal.domain.auth.application.model.RefreshToken
import com.ani.hexagonal.domain.auth.persistence.entity.RefreshTokenEntity

fun RefreshTokenEntity.toDomain() = RefreshToken(
    refreshToken = refreshToken,
    userId = userId,
    expiredAt = expiredAt
)

fun RefreshToken.toEntity() = RefreshTokenEntity(
    refreshToken = refreshToken,
    userId = userId,
    expiredAt = expiredAt
)