package com.ani.hexagonal.domain.board.application.spi;

import com.ani.hexagonal.domain.board.application.model.Category

interface CommandCategoryPort {
    fun save(category: Category): Category
}
