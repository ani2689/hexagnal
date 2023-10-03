package com.ani.hexagonal.domain.user.application.service.impl

import com.ani.hexagonal.domain.user.application.model.User
import com.ani.hexagonal.domain.user.application.service.QueryUserService
import com.ani.hexagonal.domain.user.application.spi.UserPort
import com.ani.hexagonal.global.annotation.service.DomainService

@DomainService
class QueryUserServiceImpl(
    private val userPort: UserPort
) : QueryUserService {
    override fun queryCurrentUser(): User {
        TODO("Not yet implemented")
    }

    override fun queryUserByEmail(email: String) = userPort.findByEmail(email)
}