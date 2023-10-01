package com.ani.hexagonal.domain.auth.presentation.data.res

import com.ani.hexagonal.domain.auth.application.model.JwtToken
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.ZonedDateTime

data class JwtTokenResponseData (
    val accessToken: String,
    val responseToken: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val accessExp: ZonedDateTime,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val responseExp: ZonedDateTime,
){
    companion object {
        fun of(jwtToken: JwtToken) =
            JwtTokenResponseData(
                accessToken = jwtToken.accessToken,
                responseToken = jwtToken.responseToken,
                accessExp = jwtToken.accessExp,
                responseExp = jwtToken.responseExp,
            )
    }
}