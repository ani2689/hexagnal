package com.ani.hexagonal.domain.auth.application.facade

import com.ani.hexagonal.domain.auth.presentation.data.res.GoogleLoginUrlResponseData
import com.ani.hexagonal.domain.auth.presentation.data.res.JwtTokenResponseData

interface AuthFacade {
    fun queryGoogleLoginUrl(): GoogleLoginUrlResponseData
    fun login(code: String): JwtTokenResponseData
}