package com.ani.hexagonal.global.config

import com.ani.hexagonal.global.security.filter.ExceptionFilter
import com.ani.hexagonal.global.security.filter.JwtRequestFilter
import com.ani.hexagonal.global.security.spi.JwtParserPort
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.stereotype.Component

@Component
class FilterConfig (
    private val jwtParserPort: JwtParserPort
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>(){

    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(JwtRequestFilter(jwtParserPort), UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(ExceptionFilter(), JwtRequestFilter::class.java)
    }
}