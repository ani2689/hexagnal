package com.ani.hexagonal.domain.board.presentation.data.req

data class ModifyBoardRequestData(
    val id: Long,
    val title: String,
    val content: String,
    val category: List<CategoryRequestData>
)