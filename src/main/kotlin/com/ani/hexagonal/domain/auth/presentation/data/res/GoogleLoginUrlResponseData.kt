package com.ani.hexagonal.domain.auth.presentation.data.res

data class GoogleLoginUrlResponseData(
    val url: String
){
    companion object {
        fun of(url: String) =
            GoogleLoginUrlResponseData(
                url
            )
    }
}