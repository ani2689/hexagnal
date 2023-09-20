package com.ani.hexagonal.domain.board.persistence.mapper

import com.ani.hexagonal.domain.board.application.model.Category
import com.ani.hexagonal.domain.board.persistence.entity.CategoryJpaEntity

fun Category.toEntity() = CategoryJpaEntity(
    this.id,
    this.name
)

fun CategoryJpaEntity.toDomain() = Category(
    this.id,
    this.name
)