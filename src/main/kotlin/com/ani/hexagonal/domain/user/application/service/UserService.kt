package com.ani.hexagonal.domain.user.application.service

class UserService (
    queryUserService: QueryUserService
) : QueryUserService by queryUserService