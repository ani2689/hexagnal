package com.ani.hexagonal.domain.auth.persistence

import com.ani.hexagonal.domain.auth.application.model.RefreshToken
import com.ani.hexagonal.domain.auth.application.spi.RefreshTokenPort
import com.ani.hexagonal.domain.auth.persistence.mapper.toDomain
import com.ani.hexagonal.domain.auth.persistence.mapper.toEntity
import com.ani.hexagonal.domain.auth.persistence.repository.RefreshTokenRepository
import org.springframework.stereotype.Component

@Component
class RefreshTokenAdapter(
    private val refreshTokenRepository: RefreshTokenRepository
) : RefreshTokenPort {
    override fun save(refreshToken: RefreshToken) =
        refreshTokenRepository.save(refreshToken.toEntity()).toDomain()

    override fun delete(refreshToken: RefreshToken) =
        refreshTokenRepository.delete(refreshToken.toEntity())
}