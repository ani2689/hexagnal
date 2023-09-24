package com.ani.hexagonal.domain.board.application.service.impl

import com.ani.hexagonal.domain.board.application.model.Category
import com.ani.hexagonal.domain.board.application.service.CommandCategoryService
import com.ani.hexagonal.domain.board.application.spi.CategoryPort
import com.ani.hexagonal.global.annotation.service.DomainService

@DomainService
class CommandCategoryServiceImpl(
    private val categoryPort: CategoryPort
) : CommandCategoryService {
    override fun save(category: Category) =
        categoryPort.save(category)
}