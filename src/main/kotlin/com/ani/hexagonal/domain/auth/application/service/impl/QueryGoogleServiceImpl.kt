package com.ani.hexagonal.domain.auth.application.service.impl

import com.ani.hexagonal.domain.auth.application.service.QueryGoogleService
import com.ani.hexagonal.domain.auth.application.spi.GooglePort
import com.ani.hexagonal.global.annotation.service.DomainService

@DomainService
class QueryGoogleServiceImpl(
    private val googlePort: GooglePort
) : QueryGoogleService{
    override fun queryGoogleLoginUrl() = googlePort.queryGoogleLoginUrl()

}