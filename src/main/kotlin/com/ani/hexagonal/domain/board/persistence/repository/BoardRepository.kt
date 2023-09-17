package com.ani.hexagonal.domain.board.persistence.repository

import com.ani.hexagonal.domain.board.persistence.entity.BoardJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository : JpaRepository<BoardJpaEntity, Long> {
}