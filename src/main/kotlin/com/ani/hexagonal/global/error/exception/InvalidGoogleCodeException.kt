package com.ani.hexagonal.global.error.exception

import com.ani.hexagonal.global.error.ErrorCode
import com.ani.hexagonal.global.error.basic.BoardException

class InvalidGoogleCodeException : BoardException(ErrorCode.INVALID_GOOGLE_CODE)