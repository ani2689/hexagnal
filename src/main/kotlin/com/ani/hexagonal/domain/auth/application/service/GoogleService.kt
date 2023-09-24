package com.ani.hexagonal.domain.auth.application.service

import com.ani.hexagonal.global.annotation.service.DomainService

@DomainService
class GoogleService(
    queryGoogleService: QueryGoogleService
) : QueryGoogleService by queryGoogleService