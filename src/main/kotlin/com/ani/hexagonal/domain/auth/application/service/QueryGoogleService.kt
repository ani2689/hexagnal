package com.ani.hexagonal.domain.auth.application.service

import com.ani.hexagonal.domain.auth.application.model.GoogleLoginUrl

interface QueryGoogleService {
    fun queryGoogleLoginUrl(): GoogleLoginUrl
}