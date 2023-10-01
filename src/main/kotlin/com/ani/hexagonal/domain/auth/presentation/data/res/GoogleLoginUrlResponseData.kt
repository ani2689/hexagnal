package com.ani.hexagonal.domain.auth.presentation.data.res

import com.ani.hexagonal.domain.auth.application.model.GoogleLoginUrl

data class GoogleLoginUrlResponseData(
    val url: String
){
    companion object {
        fun of(googleLoginUrl: GoogleLoginUrl) =
            GoogleLoginUrlResponseData(
                googleLoginUrl.url
            )
    }
}