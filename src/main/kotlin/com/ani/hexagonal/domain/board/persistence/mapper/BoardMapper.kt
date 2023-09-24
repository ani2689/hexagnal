package com.ani.hexagonal.domain.board.persistence.mapper

import com.ani.hexagonal.domain.board.application.model.Board
import com.ani.hexagonal.domain.board.persistence.entity.BoardJpaEntity
import com.ani.hexagonal.domain.user.persistence.mapper.toDomain
import com.ani.hexagonal.domain.user.persistence.mapper.toEntity

fun Board.toEntity() = BoardJpaEntity(
    this.id,
    this.title,
    this.content,
    this.category.map {
       it.toEntity()
    },
    this.writer.toEntity()
)

fun BoardJpaEntity.toDomain() = Board(
    this.id,
    this.title,
    this.content,
    this.category.map{
        it.toDomain()
    },
    this.writer.toDomain()
)