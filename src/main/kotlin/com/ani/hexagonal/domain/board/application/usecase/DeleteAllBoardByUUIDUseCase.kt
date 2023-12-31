package com.ani.hexagonal.domain.board.application.usecase

import com.ani.hexagonal.domain.board.application.service.BoardService
import com.ani.hexagonal.global.annotation.usecase.UseCase
import java.util.*

@UseCase
class DeleteAllBoardByUUIDUseCase (
    private val boardService: BoardService
){
    fun execute(uuid: UUID){
        boardService.findBoardByUUID(uuid)
            .map { boardService.delete(it) }
    }
}