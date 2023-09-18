package com.ani.hexagonal.domain.board.presentation.data.web

import com.ani.hexagonal.domain.board.presentation.data.req.CreateBoardRequestData
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size


data class CreateBoardWebRequest(
    @field:NotBlank
    val title: String,

    @field:Size(min = 10)
    val content: String,

    val category: List<String>
){
    fun toData() = CreateBoardRequestData(
        title,
        content,
        category
    )
}