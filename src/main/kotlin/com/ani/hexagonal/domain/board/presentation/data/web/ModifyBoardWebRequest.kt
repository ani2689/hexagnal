package com.ani.hexagonal.domain.board.presentation.data.web

import com.ani.hexagonal.domain.board.presentation.data.req.ModifyBoardRequestData
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class ModifyBoardWebRequest (
    @field:NotBlank
    val title: String,
    @field:Size(min = 10)
    val content: String,
    val category: List<CategoryRequestWebRequest>
){
    fun toData() = ModifyBoardRequestData(
        title,
        content,
        category.map {
            it.toData()
        }
    )
}