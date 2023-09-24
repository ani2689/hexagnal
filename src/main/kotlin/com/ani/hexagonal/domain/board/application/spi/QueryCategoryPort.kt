package com.ani.hexagonal.domain.board.application.spi

import com.ani.hexagonal.domain.board.application.model.Category

interface QueryCategoryPort {
    fun findByName(name: String): Category
}