package com.ani.hexagonal.global.security.jwt

import com.ani.hexagonal.domain.auth.application.model.JwtToken
import com.ani.hexagonal.domain.auth.application.model.RefreshToken
import com.ani.hexagonal.domain.auth.application.spi.RefreshTokenPort
import com.ani.hexagonal.domain.user.application.model.role.UserRole
import com.ani.hexagonal.global.security.spi.GenerateJwtPort
import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
class GenerateJwtAdapter(
    private val jwtProperties: JwtProperties,
    private val refreshTokenPort: RefreshTokenPort
) : GenerateJwtPort {
    override fun generate(userId: UUID, userRole: List<UserRole>): JwtToken {
        val accessTokoen = generateAccessToken(userId, userRole)
        val refreshToken = generateRefreshToken(userId, userRole)
        val accessExp = generateAccessExp()
        val refreshExp = generateRefreshExp()
        refreshTokenPort.save(RefreshToken(refreshToken, userId, jwtProperties.refreshExp))
        return JwtToken(
            accessTokoen,
            refreshToken,
            accessExp,
            refreshExp
        )
    }

    private fun generateAccessToken(userId: UUID, userRole: List<UserRole>) =
        Jwts.builder()
            .signWith(jwtProperties.accessSecret)
            .setSubject(userId.toString())
            .claim("type", JwtProperties.accessType)
            .claim(JwtProperties.roleType, userRole)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + jwtProperties.accessExp * 1000))
            .compact()

    private fun generateRefreshToken(userId: UUID, userRole: List<UserRole>) =
        Jwts.builder()
           .signWith(jwtProperties.refreshSecret)
           .setSubject(userId.toString())
           .claim("type", JwtProperties.refreshType)
           .claim(JwtProperties.roleType, userRole)
           .setIssuedAt(Date())
           .setExpiration(Date(System.currentTimeMillis() + jwtProperties.refreshExp * 1000))
            .compact()

    private fun generateAccessExp() =
        LocalDateTime.now().plusSeconds(jwtProperties.accessExp.toLong())

    private fun generateRefreshExp() =
        LocalDateTime.now().plusSeconds(jwtProperties.refreshExp.toLong())
}