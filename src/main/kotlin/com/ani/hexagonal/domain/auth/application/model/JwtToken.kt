package com.ani.hexagonal.domain.auth.application.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.ZonedDateTime

class JwtToken (
    val accessToken: String,
    val responseToken: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val accessExp: ZonedDateTime,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val responseExp: ZonedDateTime,
)