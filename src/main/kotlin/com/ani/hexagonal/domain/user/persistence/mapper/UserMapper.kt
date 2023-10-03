package com.ani.hexagonal.domain.user.persistence.mapper

import com.ani.hexagonal.domain.user.application.model.User
import com.ani.hexagonal.domain.user.persistence.entity.UserJpaEntity

fun User.toEntity() = UserJpaEntity(
    this.id,
    this.name,
    this.email,
    this.role.toMutableList()
)

fun UserJpaEntity.toDomain() = User(
    this.id,
    this.name,
    this.email,
    this.role
)