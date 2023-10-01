package com.ani.hexagonal.domain.auth.presentation.data.res

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
        fun of(accessToken: String, responseToken: String, accessExp: ZonedDateTime, responseExp: ZonedDateTime) =
            JwtTokenResponseData(
                accessToken = accessToken,
                responseToken = responseToken,
                accessExp = accessExp,
                responseExp = responseExp
            )
    }
}