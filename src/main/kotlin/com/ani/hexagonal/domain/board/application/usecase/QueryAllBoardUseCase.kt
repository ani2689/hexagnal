package com.ani.hexagonal.domain.board.application.usecase

import com.ani.hexagonal.domain.board.application.service.BoardService
import com.ani.hexagonal.global.annotation.usecase.UseCase

@UseCase
class QueryAllBoardUseCase (
    private val boardService: BoardService
){
    fun execute() =
        boardService.findAllBoard()
}