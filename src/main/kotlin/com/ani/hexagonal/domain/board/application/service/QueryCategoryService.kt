package com.ani.hexagonal.domain.board.application.service

import com.ani.hexagonal.domain.board.application.model.Category

interface QueryCategoryService {
    fun findByName(name: String): Category
}