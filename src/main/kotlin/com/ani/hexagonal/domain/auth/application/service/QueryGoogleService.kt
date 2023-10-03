package com.ani.hexagonal.domain.auth.application.service

import com.ani.hexagonal.domain.auth.application.model.GoogleLoginUrl
import com.ani.hexagonal.domain.auth.application.model.GoogleToken
import com.ani.hexagonal.domain.auth.application.model.GoogleUser

interface QueryGoogleService {
    fun queryGoogleLoginUrl(): GoogleLoginUrl
    fun queryGoogleToken(code: String): GoogleToken
    fun queryGoogleUserByGoogleToken(googleToken: GoogleToken): GoogleUser
}