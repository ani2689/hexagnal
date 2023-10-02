package com.ani.hexagonal.domain.auth.application.service

import com.ani.hexagonal.domain.auth.application.model.GoogleLoginUrl
import com.ani.hexagonal.domain.auth.application.model.GoogleToken

interface QueryGoogleService {
    fun queryGoogleLoginUrl(): GoogleLoginUrl
    fun queryGoogleToken(code: String): GoogleToken
}