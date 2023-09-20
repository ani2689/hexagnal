package com.ani.hexagonal.domain.user.persistence.mapper

import com.ani.hexagonal.domain.user.application.model.User
import com.ani.hexagonal.domain.user.persistence.entity.UserJpaEntity

fun User.toEntity(user: User) = UserJpaEntity(
    user.id,
    user.name,
    user.email
)

fun UserJpaEntity.toDomain(userJpaEntity: UserJpaEntity) = User(
    userJpaEntity.id,
    userJpaEntity.name,
    userJpaEntity.email
)