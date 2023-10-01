package com.ani.hexagonal.domain.auth.application.model

class GoogleToken (
    val accessToken: String,
    val refreshToken: String,
    val exp: Int
)