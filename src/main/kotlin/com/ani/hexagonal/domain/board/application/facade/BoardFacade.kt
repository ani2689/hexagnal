package com.ani.hexagonal.domain.board.application.facade

import com.ani.hexagonal.domain.board.application.model.Board
import com.ani.hexagonal.domain.board.application.model.Category
import com.ani.hexagonal.domain.board.presentation.data.req.CategoryRequestData
import com.ani.hexagonal.domain.board.presentation.data.req.CreateBoardRequestData
import com.ani.hexagonal.domain.board.presentation.data.req.ModifyBoardRequestData
import com.ani.hexagonal.domain.board.presentation.data.res.BoardDetailResponseData
import com.ani.hexagonal.domain.board.presentation.data.res.BoardResponseData
import com.ani.hexagonal.domain.user.application.model.User

interface BoardFacade {
    fun createBoard(createBoardRequestData: CreateBoardRequestData)
    fun queryAllBoard() : List<BoardResponseData>
    fun queryBoardByCategory(categories: List<CategoryRequestData>) : List<BoardResponseData>
    fun queryBoardById(id: Long) : BoardDetailResponseData
    fun queryBoardByUser(user: User) : List<BoardResponseData>
    fun checkBoard(modifyBoardRequestData: ModifyBoardRequestData)
    fun deleteBoardById(id: Long)
    fun deleteAllBoardByUser(user: User)
}