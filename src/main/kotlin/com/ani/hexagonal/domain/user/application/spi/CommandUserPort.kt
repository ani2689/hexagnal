package com.ani.hexagonal.domain.user.application.spi

import com.ani.hexagonal.domain.user.application.model.User

interface CommandUserPort {
    fun save(user: User): User
}