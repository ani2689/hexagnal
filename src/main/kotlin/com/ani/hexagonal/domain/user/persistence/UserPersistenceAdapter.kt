package com.ani.hexagonal.domain.user.persistence

import com.ani.hexagonal.domain.user.application.model.User
import com.ani.hexagonal.domain.user.application.spi.UserPort
import com.ani.hexagonal.domain.user.persistence.mapper.toDomain
import com.ani.hexagonal.domain.user.persistence.reposistory.UserRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserPersistenceAdapter(
    private val userRepository: UserRepository
) : UserPort{
    override fun findByUUID(uuid: UUID) =
        userRepository.findById(uuid).get().toDomain()

    override fun findByEmail(email: String) =
        userRepository.findByEmail(email)?.toDomain()
}