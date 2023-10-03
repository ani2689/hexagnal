package com.ani.hexagonal.domain.auth.application.model

import java.util.*


class RefreshToken (
    val refreshToken: String,
    val userId: UUID,
    val expiredAt: Int
)