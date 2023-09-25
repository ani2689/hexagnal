package com.ani.hexagonal.global.error.basic

import com.ani.hexagonal.global.error.ErrorResponseData
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BoardException::class)
    fun handleBoardException(e: BoardException) : ResponseEntity<ErrorResponseData> =
        ResponseEntity(
            ErrorResponseData(e.errorCode.message,e.errorCode.status),
            HttpStatus.valueOf(e.errorCode.status)
        )
}