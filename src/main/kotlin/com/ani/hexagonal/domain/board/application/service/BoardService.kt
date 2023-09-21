package com.ani.hexagonal.domain.board.application.service

import com.ani.hexagonal.global.annotation.service.DomainService

@DomainService
class BoardService(
    commandBoardService: CommandBoardService,
    queryBoardService: QueryBoardService
) : CommandBoardService by commandBoardService,
    QueryBoardService by queryBoardService