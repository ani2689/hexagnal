package com.ani.hexagonal.domain.user.application.model

import java.util.UUID

data class User(
    val id: UUID,
    val name: String,
    val email: String
)
