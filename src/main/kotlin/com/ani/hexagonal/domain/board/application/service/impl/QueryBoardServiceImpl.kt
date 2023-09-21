package com.ani.hexagonal.domain.board.application.service.impl

import com.ani.hexagonal.domain.board.application.model.Category
import com.ani.hexagonal.domain.board.application.service.QueryBoardService
import com.ani.hexagonal.domain.board.application.spi.BoardPort
import com.ani.hexagonal.domain.user.application.spi.UserPort
import com.ani.hexagonal.global.annotation.service.DomainService
import java.util.*

@DomainService
class QueryBoardServiceImpl(
    private val boardPort: BoardPort,
    private val userPort: UserPort
) : QueryBoardService {
    override fun findAllBoard() =
        boardPort.findAllBoard()

    override fun findBoardById(id: Long) =
        boardPort.findBoardById(id)

    override fun findBoardByUUID(uuid: UUID) =
        userPort.findByUUID(uuid)
            .let { boardPort.findBoardByWriter(it) }

    override fun findBoardByCategory(category: Category) =
        boardPort.findBoardByCategory(category)
}