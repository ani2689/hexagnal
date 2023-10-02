package com.ani.hexagonal.domain.auth.application.spi

import com.ani.hexagonal.domain.auth.application.model.GoogleLoginUrl
import com.ani.hexagonal.domain.auth.application.model.GoogleToken
import com.ani.hexagonal.domain.auth.application.model.GoogleUserInfo

interface QueryGooglePort {
    fun queryGoogleLoginUrl() : GoogleLoginUrl
    fun queryGoogleUserInfo(accessToken: String) : GoogleUserInfo
    fun queryGoogleToken(code: String) : GoogleToken
}