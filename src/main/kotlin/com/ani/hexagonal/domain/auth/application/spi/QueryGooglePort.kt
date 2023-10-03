package com.ani.hexagonal.domain.auth.application.spi

import com.ani.hexagonal.domain.auth.application.model.GoogleLoginUrl
import com.ani.hexagonal.domain.auth.application.model.GoogleToken
import com.ani.hexagonal.domain.auth.application.model.GoogleUser

interface QueryGooglePort {
    fun queryGoogleLoginUrl() : GoogleLoginUrl
    fun queryGoogleUserByGoogleToken(token: GoogleToken) : GoogleUser
    fun queryGoogleToken(code: String) : GoogleToken
}