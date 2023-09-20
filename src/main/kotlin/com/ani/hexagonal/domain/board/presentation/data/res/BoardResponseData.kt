package com.ani.hexagonal.domain.board.presentation.data.res

import com.ani.hexagonal.domain.board.application.model.Board

data class BoardResponseData(
    val id: Long,
    val title: String
){
    companion object {
        fun of(board: Board) =
            BoardResponseData(
                board.id,
                board.title
            )
    }
}