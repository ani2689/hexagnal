package com.ani.hexagonal.global.security
import com.ani.hexagonal.global.config.FilterConfig
import com.ani.hexagonal.global.security.spi.JwtParserPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
@Configuration
class SecurityConfig (
    private val jwtParserPort: JwtParserPort
){

    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain  = http
            .cors { it.disable() }
            .csrf { it.disable() }
            .formLogin { it.disable() }
            .httpBasic { it.disable() }
            .authorizeHttpRequests{
                it
                    .requestMatchers(HttpMethod.GET,"/auth").permitAll()
                    .requestMatchers(HttpMethod.GET,"/auth/login").permitAll()
                    .requestMatchers(HttpMethod.DELETE,"/auth/logout").authenticated()

                    .requestMatchers(HttpMethod.POST, "/board").authenticated()
                    .requestMatchers(HttpMethod.GET, "/board").permitAll()
                    .requestMatchers(HttpMethod.GET, "/board/category").permitAll()
                    .requestMatchers(HttpMethod.POST, "/board/{uuid}").authenticated()
                    .requestMatchers(HttpMethod.GET, "/board/{uuid}").permitAll()
                    .requestMatchers(HttpMethod.GET, "/board/{board_id}").permitAll()
                    .requestMatchers(HttpMethod.PATCH, "/board/{board_id}").authenticated()
                    .requestMatchers(HttpMethod.DELETE, "/board/{board_id}").authenticated()

                    .anyRequest().authenticated()
            }
            .apply(FilterConfig(jwtParserPort)).and()
            .build()

    @Bean
    protected fun passwordEncoder() = BCryptPasswordEncoder()
}