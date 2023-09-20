package com.ani.hexagonal.domain.board.presentation.data.res

import com.ani.hexagonal.domain.board.application.model.Board

data class BoardDetailResponseData(
    val id: Long,
    val title: String,
    val content: String,
    val category: List<String>,
    val writer: String
){
    companion object {
        fun of(board: Board) =
            BoardDetailResponseData(
                board.id,
                board.title,
                board.content,
                board.category.map {
                   it.name
                },
                board.writer.name
            )
    }
}