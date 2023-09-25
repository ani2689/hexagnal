package com.ani.hexagonal.global.google

import com.ani.hexagonal.domain.auth.application.model.GoogleLoginUrl
import com.ani.hexagonal.domain.auth.application.spi.GooglePort
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets
import org.springframework.stereotype.Component

@Component
class GoogleAdapter(
    private val googleProperties: GoogleProperties
) : GooglePort {
    override fun queryGoogleLoginUrl() =
        GoogleAuthorizationCodeRequestUrl(
            googleProperties.clientId,
            googleProperties.redirectUri,
            mutableListOf(
                "https://www.googleapis.com/auth/analytics.readonly"
            )
        ).let {
            GoogleLoginUrl(
                it.build()
            )
        }
}