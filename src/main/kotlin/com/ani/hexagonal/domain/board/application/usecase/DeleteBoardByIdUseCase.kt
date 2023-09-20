package com.ani.hexagonal.domain.board.application.usecase

import com.ani.hexagonal.domain.board.application.service.BoardService
import com.ani.hexagonal.global.annotation.service.DomainService

@DomainService
class DeleteBoardByIdUseCase(
    private val boardService: BoardService
){
    fun execute(id: Long) {
        val board = boardService.findBoardById(id)
        boardService.delete(board)
    }

}