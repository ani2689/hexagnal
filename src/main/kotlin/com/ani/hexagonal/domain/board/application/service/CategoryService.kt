package com.ani.hexagonal.domain.board.application.service

import com.ani.hexagonal.global.annotation.service.DomainService

@DomainService
class CategoryService (
    commandCategoryService: CommandCategoryService,
    queryCategoryService: QueryCategoryService
) : CommandCategoryService by commandCategoryService,
    QueryCategoryService by queryCategoryService