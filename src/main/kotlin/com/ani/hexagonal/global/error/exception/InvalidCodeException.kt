package com.ani.hexagonal.global.error.exception

import com.ani.hexagonal.global.error.ErrorCode
import com.ani.hexagonal.global.error.basic.BoardException

class InvalidCodeException : BoardException(ErrorCode.INVALID_CODE)