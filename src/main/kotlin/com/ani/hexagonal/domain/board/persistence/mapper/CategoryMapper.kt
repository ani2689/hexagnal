package com.ani.hexagonal.domain.board.persistence.mapper

import com.ani.hexagonal.domain.board.application.model.Category
import com.ani.hexagonal.domain.board.persistence.entity.CategoryJpaEntity

fun Category.toEntity(category: Category) = CategoryJpaEntity(
    category.id,
    category.name
)

fun CategoryJpaEntity.toDomain(categoryJpaEntity: CategoryJpaEntity) = Category(
    categoryJpaEntity.id,
    categoryJpaEntity.name
)