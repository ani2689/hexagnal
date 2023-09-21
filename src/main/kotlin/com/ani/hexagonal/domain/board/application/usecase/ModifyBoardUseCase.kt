package com.ani.hexagonal.domain.board.application.usecase

import com.ani.hexagonal.domain.board.application.model.Board
import com.ani.hexagonal.domain.board.application.model.Category
import com.ani.hexagonal.domain.board.application.service.BoardService
import com.ani.hexagonal.domain.board.presentation.data.req.ModifyBoardRequestData
import com.ani.hexagonal.global.annotation.usecase.UseCase

@UseCase
class ModifyBoardUseCase (
    private val boardService: BoardService
) {
    fun execute(modifyBoardRequestData: ModifyBoardRequestData) {
        boardService.save(
            Board(
                modifyBoardRequestData.id,
                modifyBoardRequestData.title,
                modifyBoardRequestData.content,
                modifyBoardRequestData.category
                    .map {
                        Category(
                            0,
                            it.name
                        )
                    },
                boardService.findBoardById(modifyBoardRequestData.id)
                    .writer
            )
        )
    }
}