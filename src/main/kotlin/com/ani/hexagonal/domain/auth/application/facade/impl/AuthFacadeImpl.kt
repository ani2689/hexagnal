package com.ani.hexagonal.domain.auth.application.facade.impl

import com.ani.hexagonal.domain.auth.application.facade.AuthFacade
import com.ani.hexagonal.domain.auth.application.usecase.LoginUseCase
import com.ani.hexagonal.domain.auth.application.usecase.QueryGoogleLoginUrlUseCase
import com.ani.hexagonal.domain.auth.presentation.data.res.GoogleLoginUrlResponseData
import com.ani.hexagonal.domain.auth.presentation.data.res.JwtTokenResponseData
import org.springframework.stereotype.Component

@Component
class AuthFacadeImpl(
    private val queryGoogleLoginUrlUseCase: QueryGoogleLoginUrlUseCase,
    private val loginUseCase: LoginUseCase
) : AuthFacade {
    override fun queryGoogleLoginUrl(): GoogleLoginUrlResponseData =
        queryGoogleLoginUrlUseCase.execute()
            .let { GoogleLoginUrlResponseData.of(it) }

    override fun login(code: String): JwtTokenResponseData =
        loginUseCase.execute(code)
           .let { JwtTokenResponseData.of(it) }
}