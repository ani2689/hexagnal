package com.ani.hexagonal.global.security.spi

import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.core.Authentication

interface JwtParserPort {
    fun parseAccessToken(request: HttpServletRequest): String?
    fun parseRefreshToken(refreshToken: String): String?
    fun authentication(accessToken: String): Authentication
    fun isRefreshTokenExpired(refreshToken: String): Boolean
}