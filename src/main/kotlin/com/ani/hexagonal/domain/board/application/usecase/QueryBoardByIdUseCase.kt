package com.ani.hexagonal.domain.board.application.usecase

import com.ani.hexagonal.domain.board.application.service.BoardService
import com.ani.hexagonal.global.annotation.usecase.ReadOnlyUseCase

@ReadOnlyUseCase
class QueryBoardByIdUseCase (
    private val boardService: BoardService
){
    fun execute(id: Long) =
        boardService.findBoardById(id)
}