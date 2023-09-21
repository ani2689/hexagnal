package com.ani.hexagonal.domain.board.application.facade.impl

import com.ani.hexagonal.domain.board.application.facade.BoardFacade
import com.ani.hexagonal.domain.board.application.usecase.*
import com.ani.hexagonal.domain.board.presentation.data.req.CategoryRequestData
import com.ani.hexagonal.domain.board.presentation.data.req.CreateBoardRequestData
import com.ani.hexagonal.domain.board.presentation.data.req.ModifyBoardRequestData
import com.ani.hexagonal.domain.board.presentation.data.res.BoardDetailResponseData
import com.ani.hexagonal.domain.board.presentation.data.res.BoardResponseData
import org.springframework.stereotype.Component
import java.util.*

@Component
class BoardFacadeImpl(
    private val createBoardUseCase: CreateBoardUseCase,
    private val modifyBoardUseCase: ModifyBoardUseCase,
    private val deleteBoardByIdUseCase: DeleteBoardByIdUseCase,
    private val deleteAllBoardByUUIDUseCase: DeleteAllBoardByUUIDUseCase,
    private val queryAllBoardUseCase: QueryAllBoardUseCase,
    private val queryBoardByUUIDUseCase: QueryBoardByUUIDUseCase,
    private val queryBoardByIdUseCase: QueryBoardByIdUseCase,
    private val queryBoardByCategoryUseCase: QueryBoardByCategoryUseCase
) : BoardFacade {
    override fun createBoard(createBoardRequestData: CreateBoardRequestData) =
        createBoardUseCase.execute(createBoardRequestData)

    override fun queryAllBoard(): List<BoardResponseData> =
        queryAllBoardUseCase.execute()
            .map {
                BoardResponseData.of(it)
            }

    override fun queryBoardByCategory(category: List<CategoryRequestData>): List<BoardResponseData> =
        queryBoardByCategoryUseCase.execute(category)
            .map {
                BoardResponseData.of(it)
            }

    override fun queryBoardById(id: Long): BoardDetailResponseData =
        queryBoardByIdUseCase.execute(id)
            .let{ BoardDetailResponseData.of(it) }

    override fun queryBoardByUUID(uuid: UUID): List<BoardResponseData> =
        queryBoardByUUIDUseCase.execute(uuid)
            .map {
                BoardResponseData.of(it)
            }

    override fun modifyBoard(modifyBoardRequestData: ModifyBoardRequestData) =
        modifyBoardUseCase.execute(modifyBoardRequestData)

    override fun deleteBoardById(id: Long) =
        deleteBoardByIdUseCase.execute(id)

    override fun deleteAllBoardByUUID(uuid: UUID) =
        deleteAllBoardByUUIDUseCase.execute(uuid)
}