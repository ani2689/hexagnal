package com.ani.hexagonal.domain.board.persistence

import com.ani.hexagonal.domain.board.application.model.Board
import com.ani.hexagonal.domain.board.application.spi.BoardPort
import com.ani.hexagonal.domain.board.persistence.mapper.toDomain
import com.ani.hexagonal.domain.board.persistence.mapper.toEntity
import com.ani.hexagonal.domain.board.persistence.repository.BoardRepository
import org.springframework.stereotype.Component

@Component
class BoardPersistenceAdapter(
    private val boardRepository: BoardRepository
) : BoardPort{
    override fun save(board: Board): Board =
        boardRepository.save(board.toEntity()).toDomain()

    override fun delete(board: Board) =
        boardRepository.delete(board.toEntity())
}