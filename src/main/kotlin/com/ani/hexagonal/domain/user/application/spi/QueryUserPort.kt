package com.ani.hexagonal.domain.user.application.spi

import com.ani.hexagonal.domain.user.application.model.User
import java.util.UUID

interface QueryUserPort {
    fun findByUUID(uuid: UUID): User
    fun findByEmail(email: String): User?
}