package com.ani.hexagonal.domain.board.application.service

import com.ani.hexagonal.domain.board.application.model.Board
import com.ani.hexagonal.domain.board.application.model.Category

interface QueryBoardService {
    fun findAllBoard(): List<Board>
    fun findBoardById(id: Long): Board
    fun findBoardByUUID(uuid: Long): List<Board>
    fun findBoardByCategory(category: Category): List<Board>
}