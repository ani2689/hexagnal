package com.ani.hexagonal.global.security.spi

import com.ani.hexagonal.domain.auth.application.model.JwtToken
import com.ani.hexagonal.domain.user.application.model.role.UserRole
import java.util.UUID

interface GenerateJwtPort {
    fun generate(userId: UUID, userRole: List<UserRole>): JwtToken
}