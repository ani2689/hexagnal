package com.ani.hexagonal.domain.board.application.spi

import com.ani.hexagonal.domain.board.application.model.Board
import com.ani.hexagonal.domain.board.application.model.Category
import java.util.*

interface QueryBoardPort {
    fun findAllBoard(): List<Board>
    fun findBoardById(id: Long): Board
    fun findBoardByUUID(uuid: UUID): List<Board>
    fun findBoardByCategory(category: Category): List<Board>
}