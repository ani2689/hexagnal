package com.ani.hexagonal.global.google

import com.ani.hexagonal.domain.auth.application.model.GoogleLoginUrl
import com.ani.hexagonal.domain.auth.application.spi.GooglePort
import org.springframework.stereotype.Component

@Component
class GoogleAdapter(
    private val googleProperties: GoogleProperties
) : GooglePort {
    override fun queryGoogleLoginUrl() = GoogleLoginUrl(
        "https://accounts.google.com/o/oauth2/v2/auth?" +
                "client_id=${googleProperties.clientId}," +
                "redirect_uri=${googleProperties.redirectUri}," +
                "response_type=code"
    )
}