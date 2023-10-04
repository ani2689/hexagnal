package com.ani.hexagonal.domain.auth.presentation.data.res

import com.ani.hexagonal.domain.auth.application.model.JwtToken
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class JwtTokenResponseData (
    val accessToken: String,
    val refreshToken: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val accessExp: LocalDateTime,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val refreshExp: LocalDateTime,
){
    companion object {
        fun of(jwtToken: JwtToken) =
            JwtTokenResponseData(
                accessToken = jwtToken.accessToken,
                refreshToken = jwtToken.refreshToken,
                accessExp = jwtToken.accessExp,
                refreshExp = jwtToken.refreshExp,
            )
    }
}