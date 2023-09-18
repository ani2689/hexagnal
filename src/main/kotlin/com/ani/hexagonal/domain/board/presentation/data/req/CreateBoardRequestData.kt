package com.ani.hexagonal.domain.board.presentation.data.req

data class CreateBoardRequestData(
    val title: String,
    val content: String,
    val category: List<String>
)