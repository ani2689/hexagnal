package com.ani.hexagonal.domain.board.application.spi

import com.ani.hexagonal.domain.board.application.model.Board
import com.ani.hexagonal.domain.board.application.model.Category
import com.ani.hexagonal.domain.user.application.model.User

interface QueryBoardPort {
    fun findAllBoard(): List<Board>
    fun findBoardById(id: Long): Board
    fun findBoardByWriter(writer: User): List<Board>
    fun findBoardByCategory(category: Category): List<Board>
}