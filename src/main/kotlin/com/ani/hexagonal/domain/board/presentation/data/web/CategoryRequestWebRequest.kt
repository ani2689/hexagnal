package com.ani.hexagonal.domain.board.presentation.data.web

import com.ani.hexagonal.domain.board.presentation.data.req.CategoryRequestData
import jakarta.validation.constraints.Max

data class CategoryRequestWebRequest (
    @field:Max(10)
    val name: String
){
    fun toData() = CategoryRequestData(
        name
    )
}