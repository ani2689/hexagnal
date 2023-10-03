package com.ani.hexagonal.domain.user.application.service

import com.ani.hexagonal.domain.user.application.model.User


interface QueryUserService {
    fun queryCurrentUser(): User
    fun queryUserByEmail(email: String): User?
}