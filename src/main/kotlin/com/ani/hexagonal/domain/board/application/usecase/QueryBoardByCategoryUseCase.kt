package com.ani.hexagonal.domain.board.application.usecase

import com.ani.hexagonal.domain.board.application.model.Board
import com.ani.hexagonal.domain.board.application.model.Category
import com.ani.hexagonal.domain.board.application.service.BoardService
import com.ani.hexagonal.domain.board.presentation.data.req.CategoryRequestData
import com.ani.hexagonal.global.annotation.usecase.UseCase

@UseCase
class QueryBoardByCategoryUseCase (
    private val boardService: BoardService
){
    fun execute(category: List<CategoryRequestData>): List<Board> {

        val board = mutableSetOf<Board>()

        category.map { req ->
            Category(
                0,
                req.name
            ).let { dom -> boardService.findBoardByCategory(dom) }
                .let { board.addAll(it) }
        }

        return ArrayList(board)
    }
}