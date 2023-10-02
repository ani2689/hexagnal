package com.ani.hexagonal.global.google

import com.ani.hexagonal.domain.auth.application.model.GoogleLoginUrl
import com.ani.hexagonal.domain.auth.application.model.GoogleToken
import com.ani.hexagonal.domain.auth.application.model.GoogleUserInfo
import com.ani.hexagonal.domain.auth.application.spi.GooglePort
import com.ani.hexagonal.global.error.exception.InvalidCodeException
import com.fasterxml.jackson.databind.JsonNode
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
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
            "&scope=" +
                " email" +
                " profile"
    )

    override fun queryGoogleUserInfo(accessToken: String): GoogleUserInfo {
        TODO()
    }

    override fun queryGoogleToken(code: String): GoogleToken {
        try {
            val googleReq: MultiValueMap<String, String> = LinkedMultiValueMap()

            googleReq.add("code", code)
            googleReq.add("client_id", googleProperties.clientId)
            googleReq.add("client_secret", googleProperties.clientSecret)
            googleReq.add("redirect_uri", googleProperties.redirectUri)
            googleReq.add("grant_type", "authorization_code")

            val googleRes = HttpEntity(googleReq,HttpHeaders())
                .let { RestTemplate().exchange(
                    "https://oauth2.googleapis.com/token",
                    HttpMethod.POST,
                    it,
                    JsonNode::class.java
                )}.body!!

            return GoogleToken(
                googleRes.get("access_token").asText(),
                googleRes.get("id_token").asText(),
                googleRes.get("expires_in").asInt()
            )
        } catch (e: Exception) {
            when (e.message!!.split(" ")[0]) {
                "400" -> throw InvalidCodeException()
                else -> throw e
            }
        }
    }
}