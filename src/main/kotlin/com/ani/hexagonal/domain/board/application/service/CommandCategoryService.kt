package com.ani.hexagonal.domain.board.application.service

import com.ani.hexagonal.domain.board.application.model.Category

interface CommandCategoryService {
    fun save(category: Category)
}