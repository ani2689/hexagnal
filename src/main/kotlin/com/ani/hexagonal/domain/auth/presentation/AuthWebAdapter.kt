package com.ani.hexagonal.domain.auth.presentation

import com.ani.hexagonal.domain.auth.application.facade.AuthFacade
import com.ani.hexagonal.domain.auth.presentation.data.res.GoogleLoginUrlResponseData
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthWebAdapter (
    private val authFacade: AuthFacade
){
    fun queryGoogleLoginUrl(): ResponseEntity<GoogleLoginUrlResponseData> =
        authFacade.queryGoogleLoginUrl()
            .let { ResponseEntity.ok(it) }
}