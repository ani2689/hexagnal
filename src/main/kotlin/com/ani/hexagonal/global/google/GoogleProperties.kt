package com.ani.hexagonal.global.google

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "google")
data class GoogleProperties(
    val clientId: String,
    val clientSecret: String,
    val redirectUri: String
)