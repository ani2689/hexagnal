package com.ani.hexagonal.global.security.filter

import com.ani.hexagonal.global.error.ErrorCode
import com.ani.hexagonal.global.error.ErrorResponseData
import com.ani.hexagonal.global.error.basic.BoardException
import com.fasterxml.jackson.databind.ObjectMapper
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.JwtException
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
        runCatching {
            filterChain.doFilter(request, response)
        }.onFailure { e ->
            when(e) {
                is ExpiredJwtException -> exceptionToResponse(ErrorCode.EXPIRED_ACCESS_TOKEN, response)
                is JwtException -> exceptionToResponse(ErrorCode.INVALID_TOKEN, response)
                is BoardException -> exceptionToResponse(e.errorCode, response)
                else -> throw e
            }
        }
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