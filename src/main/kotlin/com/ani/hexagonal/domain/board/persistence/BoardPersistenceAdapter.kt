package com.ani.hexagonal.domain.board.persistence

import com.ani.hexagonal.domain.board.application.model.Board
import com.ani.hexagonal.domain.board.application.model.Category
import com.ani.hexagonal.domain.board.application.spi.BoardPort
import com.ani.hexagonal.domain.board.persistence.mapper.toDomain
import com.ani.hexagonal.domain.board.persistence.mapper.toEntity
import com.ani.hexagonal.domain.board.persistence.repository.BoardRepository
import com.ani.hexagonal.domain.user.application.model.User
import com.ani.hexagonal.domain.user.persistence.mapper.toEntity
import org.springframework.stereotype.Component

@Component
class BoardPersistenceAdapter(
    private val boardRepository: BoardRepository
) : BoardPort{
    override fun save(board: Board): Board =
        boardRepository.save(board.toEntity()).toDomain()

    override fun delete(board: Board) =
        boardRepository.delete(board.toEntity())

    override fun findAllBoard() =
        boardRepository.findAll()
            .map {
                it.toDomain()
            }

    override fun findBoardById(id: Long) =
        boardRepository.findById(id).get().toDomain()

    override fun findBoardByWriter(writer: User): List<Board> =
        boardRepository.findByWriter(writer.toEntity())
            .map {
                it.toDomain()
            }
    override fun findBoardByCategory(category: Category): List<Board> =
        boardRepository.findByCategoryContaining(category.toEntity())
            .map {
                it.toDomain()
            }
}