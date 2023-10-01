package com.ani.hexagonal.domain.auth.presentation

import com.ani.hexagonal.domain.auth.application.facade.AuthFacade
import com.ani.hexagonal.domain.auth.presentation.data.res.GoogleLoginUrlResponseData
import com.ani.hexagonal.domain.auth.presentation.data.res.JwtTokenResponseData
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthWebAdapter (
    private val authFacade: AuthFacade
){
    @GetMapping
    fun queryGoogleLoginUrl(): ResponseEntity<GoogleLoginUrlResponseData> {
        return authFacade.queryGoogleLoginUrl()
            .let { ResponseEntity.ok(it)}
    }

    @GetMapping("/login")
    fun login(@RequestParam code: String): ResponseEntity<JwtTokenResponseData> =
        authFacade.login(code)
            .let { ResponseEntity.ok(it) }
}