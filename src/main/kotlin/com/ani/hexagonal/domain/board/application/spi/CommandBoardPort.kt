package com.ani.hexagonal.domain.board.application.spi

import com.ani.hexagonal.domain.board.application.model.Board

interface CommandBoardPort {
    fun save(board: Board): Board
    fun delete(board: Board)
}