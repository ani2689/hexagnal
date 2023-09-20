package com.ani.hexagonal.domain.board.persistence.mapper

import com.ani.hexagonal.domain.board.application.model.Board
import com.ani.hexagonal.domain.board.persistence.entity.BoardJpaEntity
import com.ani.hexagonal.domain.user.persistence.mapper.toEntity

fun Board.toEntity(board: Board) = BoardJpaEntity(
    board.id,
    board.title,
    board.content,
    board.category.map {
       it.toEntity(it)
    },
    board.writer.toEntity(board.writer)
)