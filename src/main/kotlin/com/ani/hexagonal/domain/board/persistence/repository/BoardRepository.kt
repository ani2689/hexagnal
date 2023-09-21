package com.ani.hexagonal.domain.board.persistence.repository

import com.ani.hexagonal.domain.board.persistence.entity.BoardJpaEntity
import com.ani.hexagonal.domain.board.persistence.entity.CategoryJpaEntity
import com.ani.hexagonal.domain.user.persistence.entity.UserJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository : JpaRepository<BoardJpaEntity, Long> {
    fun findByWriter(writer: UserJpaEntity): List<BoardJpaEntity>
    fun findByCategoryContaining(categoryJpaEntity: CategoryJpaEntity): List<BoardJpaEntity>
}