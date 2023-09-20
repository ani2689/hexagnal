package com.ani.hexagonal.domain.board.presentation.data.req

data class ModifyBoardRequestData(
    val title: String,
    val content: String,
    val category: List<String>
)