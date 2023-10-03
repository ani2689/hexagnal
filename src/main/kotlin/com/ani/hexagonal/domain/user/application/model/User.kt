package com.ani.hexagonal.domain.user.application.model

import com.ani.hexagonal.domain.user.application.model.role.UserRole
import java.util.UUID

data class User(
    val id: UUID,
    val name: String,
    val email: String,
    val role: List<UserRole>
)
