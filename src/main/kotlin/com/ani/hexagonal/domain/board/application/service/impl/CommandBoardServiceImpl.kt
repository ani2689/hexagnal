package com.ani.hexagonal.domain.board.application.service.impl

import com.ani.hexagonal.domain.board.application.model.Board
import com.ani.hexagonal.domain.board.application.service.CommandBoardService
import com.ani.hexagonal.domain.board.application.spi.BoardPort
import com.ani.hexagonal.global.annotation.service.DomainService

@DomainService
class CommandBoardServiceImpl(
    private val boardPort: BoardPort
) : CommandBoardService {
    override fun save(board: Board): Board =
        boardPort.save(board)

    override fun delete(board: Board) {
        boardPort.delete(board)
    }
}