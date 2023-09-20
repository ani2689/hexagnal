package com.ani.hexagonal.domain.board.application.service

import com.ani.hexagonal.domain.board.application.model.Board

interface CommandBoardService {
    fun save(board: Board): Board
    fun delete(board: Board)
}