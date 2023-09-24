package com.ani.hexagonal.domain.board.persistence

import com.ani.hexagonal.domain.board.application.model.Category
import com.ani.hexagonal.domain.board.application.spi.CategoryPort
import com.ani.hexagonal.domain.board.persistence.mapper.toDomain
import com.ani.hexagonal.domain.board.persistence.mapper.toEntity
import com.ani.hexagonal.domain.board.persistence.repository.CategoryRepository
import org.springframework.stereotype.Component

@Component
class CategoryPersistenceAdapter(
    private val categoryRepository: CategoryRepository
) : CategoryPort{
    override fun save(category: Category) =
        categoryRepository.save(category.toEntity()).toDomain()

    override fun findByName(name: String) =
        categoryRepository.findByName(name).toDomain()
}