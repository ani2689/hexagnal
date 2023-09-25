package com.ani.hexagonal.global.error.basic

import com.ani.hexagonal.global.error.ErrorCode

open class BoardException(
    val errorCode: ErrorCode
) : RuntimeException(errorCode.message)