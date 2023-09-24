package com.ani.hexagonal.domain.auth.application.usecase

import com.ani.hexagonal.domain.auth.application.service.GoogleService
import com.ani.hexagonal.global.annotation.usecase.ReadOnlyUseCase

@ReadOnlyUseCase
class QueryGoogleLoginUrlUseCase (
    private val googleService: GoogleService
){
    fun execute() = googleService.queryGoogleLoginUrl()

}