package com.ani.hexagonal.global.security.principle

import com.ani.hexagonal.domain.user.application.spi.UserPort
import com.ani.hexagonal.domain.user.persistence.mapper.toEntity
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional(readOnly = true, rollbackFor = [Exception::class])
class AuthDetailsService(
    private val userPort: UserPort
) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails =
        AuthDetails(
            userPort.findByUUID(UUID.fromString(username)).toEntity()
        )
}