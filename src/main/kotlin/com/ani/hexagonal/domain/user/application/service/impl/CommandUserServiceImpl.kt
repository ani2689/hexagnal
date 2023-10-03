package com.ani.hexagonal.domain.user.application.service.impl

import com.ani.hexagonal.domain.user.application.model.User
import com.ani.hexagonal.domain.user.application.service.CommandUserService
import com.ani.hexagonal.domain.user.application.spi.UserPort
import com.ani.hexagonal.global.annotation.service.DomainService

@DomainService
class CommandUserServiceImpl(
    private val userPort: UserPort
) : CommandUserService {
    override fun save(user: User) = userPort.save(user)
}