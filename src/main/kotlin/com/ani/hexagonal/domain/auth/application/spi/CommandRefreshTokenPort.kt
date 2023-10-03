package com.ani.hexagonal.domain.auth.application.spi

import com.ani.hexagonal.domain.auth.application.model.RefreshToken

interface CommandRefreshTokenPort {
    fun save(refreshToken: RefreshToken): RefreshToken
    fun delete(refreshToken: RefreshToken)
}