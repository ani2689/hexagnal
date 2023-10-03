package com.ani.hexagonal.domain.user.application.service

import com.ani.hexagonal.global.annotation.service.DomainService

@DomainService
class UserService (
    queryUserService: QueryUserService,
    commandUserService: CommandUserService
) : QueryUserService by queryUserService,
    CommandUserService by commandUserService