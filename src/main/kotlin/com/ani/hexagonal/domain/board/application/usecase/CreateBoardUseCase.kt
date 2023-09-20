package com.ani.hexagonal.domain.board.application.usecase

import com.ani.hexagonal.domain.board.application.model.Board
import com.ani.hexagonal.domain.board.application.model.Category
import com.ani.hexagonal.domain.board.application.service.BoardService
import com.ani.hexagonal.domain.board.application.service.CategoryService
import com.ani.hexagonal.domain.board.presentation.data.req.CreateBoardRequestData
import com.ani.hexagonal.domain.user.application.service.UserService
import com.ani.hexagonal.global.annotation.usecase.UseCase

@UseCase
class CreateBoardUseCase (
    private val userService: UserService,
    private val boardService: BoardService,
    private val categoryService: CategoryService
){
    fun execute(board: CreateBoardRequestData){
        val currentUser = userService.queryCurrentUser()
        board.category.map {
            categoryService.findByName(it)?:Category(0, it)
                .let { categoryEntity -> categoryService.save(categoryEntity) }
        }
        boardService.save(Board(
            0,
            board.title,
            board.content,
            board.category.map {
                categoryService.findByName(it)!!
            },
            currentUser
        ))
    }
}