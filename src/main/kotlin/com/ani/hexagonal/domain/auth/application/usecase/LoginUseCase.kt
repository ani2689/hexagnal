package com.ani.hexagonal.domain.auth.application.usecase

import com.ani.hexagonal.domain.auth.application.model.JwtToken
import com.ani.hexagonal.domain.auth.application.service.GoogleService
import com.ani.hexagonal.domain.user.application.model.User
import com.ani.hexagonal.domain.user.application.model.role.UserRole
import com.ani.hexagonal.domain.user.application.service.UserService
import com.ani.hexagonal.global.annotation.usecase.UseCase
import com.ani.hexagonal.global.security.spi.GenerateJwtPort
import java.util.*

@UseCase
class LoginUseCase (
    private val googleService: GoogleService,
    private val userService: UserService,
    private val generateJwtPort: GenerateJwtPort
){
    fun execute(code: String): JwtToken {
        val googleToken = googleService.queryGoogleToken(code)
        val googleUser = googleService.queryGoogleUserByGoogleToken(googleToken)

        val user = userService.queryUserByEmail(googleUser.email)?: userService.save(User(
            UUID.randomUUID(),
            googleUser.email,
            googleUser.name,
            mutableListOf(UserRole.ROLE_MEMBER)
        ))

        return generateJwtPort.generate(user.id, user.role)
    }
}