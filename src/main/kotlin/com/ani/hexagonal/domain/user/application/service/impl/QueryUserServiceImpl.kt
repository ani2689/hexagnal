package com.ani.hexagonal.domain.user.application.service.impl

import com.ani.hexagonal.domain.user.application.model.User
import com.ani.hexagonal.domain.user.application.service.QueryUserService
import com.ani.hexagonal.global.annotation.service.DomainService

@DomainService
class QueryUserServiceImpl : QueryUserService {
    override fun queryCurrentUser(): User {
        TODO("Not yet implemented")
    }
}