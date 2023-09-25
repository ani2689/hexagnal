package com.ani.hexagonal.global.security.filter

import com.ani.hexagonal.global.error.ErrorCode
import com.ani.hexagonal.global.error.ErrorResponseData
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.filter.OncePerRequestFilter

class ExceptionFilter : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ){

    }

    private fun exceptionToResponse(errorCode: ErrorCode, response: HttpServletResponse) {
        response.status = errorCode.status
        response.contentType = "application/json"
        response.characterEncoding = "utf-8"

        val errorResponseData = ErrorResponseData(errorCode.message, errorCode.status)
        val errorResponseToJson = ObjectMapper().writeValueAsString(errorResponseData)

        response.writer.write(errorResponseToJson)
    }
}