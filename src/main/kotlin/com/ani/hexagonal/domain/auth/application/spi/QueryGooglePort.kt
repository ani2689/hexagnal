package com.ani.hexagonal.domain.auth.application.spi

import com.ani.hexagonal.domain.auth.application.model.GoogleLoginUrl

interface QueryGooglePort {
    fun queryGoogleLoginUrl() : GoogleLoginUrl
}