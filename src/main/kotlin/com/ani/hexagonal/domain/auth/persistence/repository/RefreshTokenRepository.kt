package com.ani.hexagonal.domain.auth.persistence.repository

import com.ani.hexagonal.domain.auth.persistence.entity.RefreshTokenEntity
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshTokenEntity, String> {
}