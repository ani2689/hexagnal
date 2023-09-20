package com.ani.hexagonal.domain.board.application.facade

import com.ani.hexagonal.domain.board.presentation.data.req.CategoryRequestData
import com.ani.hexagonal.domain.board.presentation.data.req.CreateBoardRequestData
import com.ani.hexagonal.domain.board.presentation.data.req.ModifyBoardRequestData
import com.ani.hexagonal.domain.board.presentation.data.res.BoardDetailResponseData
import com.ani.hexagonal.domain.board.presentation.data.res.BoardResponseData
import java.util.UUID

interface BoardFacade {
    fun createBoard(createBoardRequestData: CreateBoardRequestData)
    fun queryAllBoard() : List<BoardResponseData>
    fun queryBoardByCategory(categories: List<CategoryRequestData>) : List<BoardResponseData>
    fun queryBoardById(id: Long) : BoardDetailResponseData
    fun queryBoardByUUID(uuid: UUID) : List<BoardResponseData>
    fun modifyBoard(modifyBoardRequestData: ModifyBoardRequestData)
    fun deleteBoardById(id: Long)
    fun deleteAllBoardByUUID(uuid: UUID)
}