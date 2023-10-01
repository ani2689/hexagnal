package com.ani.hexagonal.global.google

import com.ani.hexagonal.domain.auth.application.model.GoogleLoginUrl
import com.ani.hexagonal.domain.auth.application.model.GoogleToken
import com.ani.hexagonal.domain.auth.application.model.GoogleUserInfo
import com.ani.hexagonal.domain.auth.application.spi.GooglePort
import com.ani.hexagonal.global.error.exception.InvalidCodeException
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate


@Component
class GoogleAdapter(
    private val googleProperties: GoogleProperties
) : GooglePort {

    override fun queryGoogleLoginUrl() = GoogleLoginUrl(
        "https://accounts.google.com/o/oauth2/v2/auth?" +
            "client_id=${googleProperties.clientId}" +
            "&redirect_uri=${googleProperties.redirectUri}" +
            "&response_type=code" +
            "&scope=https://www.googleapis.com/auth/analytics.readonly"
    )

    override fun queryGoogleUserInfo(accessToken: String): GoogleUserInfo {
        TODO()
    }

    override fun queryGoogleToken(code: String): GoogleToken =
        GoogleReq(
            googleProperties.redirectUri,
            googleProperties.clientId,
            googleProperties.clientSecret,
            code,
            "authorization_code"
        ).let {
            RestTemplate().postForEntity(
                "https://oauth2.googleapis.com", it,
                GoogleRes::class.java
            ).body
        }.let {
            it ?: throw InvalidCodeException()
            GoogleToken(
                it.accessToken,
                it.refreshToken,
                it.expires_in.toInt()
            )
        }



    private class GoogleReq (
        val redirectUri: String,
        val clientId: String,
        val clientSecret: String,
        val code: String,
        val grantType: String,
    )

    private class GoogleRes (
        val accessToken: String,
        val refreshToken: String,
        val expires_in: String
    )
}