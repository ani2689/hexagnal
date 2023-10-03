package com.ani.hexagonal.domain.user.application.service

import com.ani.hexagonal.domain.user.application.model.User

interface CommandUserService {
    fun save(user: User): User
}