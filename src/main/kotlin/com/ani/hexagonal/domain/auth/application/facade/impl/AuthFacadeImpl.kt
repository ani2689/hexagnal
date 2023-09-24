package com.ani.hexagonal.domain.auth.application.facade.impl

import com.ani.hexagonal.domain.auth.application.facade.AuthFacade
import com.ani.hexagonal.domain.auth.application.usecase.QueryGoogleLoginUrlUseCase
import com.ani.hexagonal.domain.auth.presentation.data.res.GoogleLoginUrlResponseData
import org.springframework.stereotype.Component

@Component
class AuthFacadeImpl(
    private val queryGoogleLoginUrlUseCase: QueryGoogleLoginUrlUseCase
) : AuthFacade {
    override fun queryGoogleLoginUrl(): GoogleLoginUrlResponseData =
        queryGoogleLoginUrlUseCase.execute()
            .let { GoogleLoginUrlResponseData.of(it.url) }
}