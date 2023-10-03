package com.ani.hexagonal.domain.auth.application.model

import org.hibernate.validator.constraints.UUID

class RefreshToken (
    val refreshToken: String,
    val userId: UUID,
    val expiredAt: Int
)