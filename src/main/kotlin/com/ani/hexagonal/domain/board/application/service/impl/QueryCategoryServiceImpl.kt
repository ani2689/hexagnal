package com.ani.hexagonal.domain.board.application.service.impl

import com.ani.hexagonal.domain.board.application.service.QueryCategoryService
import com.ani.hexagonal.domain.board.application.spi.CategoryPort
import com.ani.hexagonal.global.annotation.service.DomainService

@DomainService
class QueryCategoryServiceImpl(
    private val categoryPort: CategoryPort
) : QueryCategoryService {
    override fun findByName(name: String) =
        categoryPort.findByName(name)
}