package com.ani.hexagonal.domain.user.application.service

import com.ani.hexagonal.domain.user.application.model.User


interface QueryUserService {
    fun queryCurrentUser(email: String): User
}