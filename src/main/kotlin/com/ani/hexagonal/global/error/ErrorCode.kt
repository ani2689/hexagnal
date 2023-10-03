package com.ani.hexagonal.global.error

enum class ErrorCode(
    val message: String,
    val status: Int
){
    EXPIRED_ACCESS_TOKEN("만료된 토큰입니다.", 401),
    INVALID_TOKEN("유효하지 않은 토큰입니다.", 401),
    INVALID_GOOGLE_CODE("유효하지 않은 코드입니다.",401)
}