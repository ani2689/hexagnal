package com.ani.hexagonal.domain.board.persistence.repository

import com.ani.hexagonal.domain.board.persistence.entity.CategoryJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<CategoryJpaEntity, Long> {
    fun findByName(name: String): CategoryJpaEntity
}