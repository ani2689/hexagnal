package com.ani.hexagonal.global.security.jwt

import io.jsonwebtoken.security.Keys
import org.springframework.boot.context.properties.ConfigurationProperties
import java.nio.charset.StandardCharsets
import java.security.Key

@ConfigurationProperties(prefix = "jwt")
class JwtProperties(
    accessSecret: String,
    refreshSecret: String,
    val accessExp: Int,
    val refreshExp: Int
) {
    companion object{
        const val accessType = "access"
        const val refreshType = "refresh"
        const val tokenPrefix = "Bearer "
        const val tokenHeader = "Authorization"
        const val roleType = "ROLE"
    }

    val accessSecret: Key = Keys.hmacShaKeyFor(accessSecret.toByteArray(StandardCharsets.UTF_8))
    val refreshSecret: Key = Keys.hmacShaKeyFor(refreshSecret.toByteArray(StandardCharsets.UTF_8))
}
