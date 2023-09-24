package com.ani.hexagonal.domain.auth.application.facade

import com.ani.hexagonal.domain.auth.presentation.data.res.GoogleLoginUrlResponseData

interface AuthFacade {
    fun queryGoogleLoginUrl(): GoogleLoginUrlResponseData
}