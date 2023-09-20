package com.ani.hexagonal.domain.board.presentation

import com.ani.hexagonal.domain.board.application.facade.BoardFacade
import com.ani.hexagonal.domain.board.presentation.data.req.CategoryRequestData
import com.ani.hexagonal.domain.board.presentation.data.res.BoardDetailResponseData
import com.ani.hexagonal.domain.board.presentation.data.res.BoardResponseData
import com.ani.hexagonal.domain.board.presentation.data.web.CategoryRequestWebRequest
import com.ani.hexagonal.domain.board.presentation.data.web.CreateBoardWebRequest
import com.ani.hexagonal.domain.board.presentation.data.web.ModifyBoardWebRequest
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Locale.Category
import java.util.UUID

@RestController
@RequestMapping("/board")
class BoardWebAdapter (
    private val boardFacade: BoardFacade
){
    @PostMapping
    fun createBoard(@RequestParam @Valid createBoardWebRequest: CreateBoardWebRequest): ResponseEntity<Void> =
        boardFacade.createBoard(createBoardWebRequest.toData())
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @GetMapping
    fun queryAllBoard(): ResponseEntity<List<BoardResponseData>> =
        boardFacade.queryAllBoard()
            .let { ResponseEntity.ok(it) }

    @GetMapping("/category")
    fun queryBoardByCategory(@RequestParam @Valid category: List<CategoryRequestWebRequest>): ResponseEntity<List<BoardResponseData>> =
        boardFacade.queryBoardByCategory(category.map { it.toData() })
            .let { ResponseEntity.ok(it) }

    @GetMapping("/{uuid}")
    fun queryBoardByUUID(@PathVariable uuid: UUID): ResponseEntity<List<BoardResponseData>> =
        boardFacade.queryBoardByUUID(uuid)
            .let { ResponseEntity.ok(it) }

    @DeleteMapping("/{uuid}")
    fun deleteBoardByUUID(@PathVariable uuid: UUID): ResponseEntity<List<BoardResponseData>> =
        boardFacade.deleteAllBoardByUUID(uuid)
            .let { ResponseEntity.noContent().build() }

    @GetMapping("/{board_id}")
    fun modifyBoardById(@PathVariable("board_id") boardId: Long): ResponseEntity<BoardDetailResponseData> =
        boardFacade.queryBoardById(boardId)
            .let { ResponseEntity.ok(it) }

    @PatchMapping("/{board_id}")
    fun modifyBoardById(@PathVariable("board_id") boardId: Long, @RequestParam @Valid modifyBoardWebRequest: ModifyBoardWebRequest): ResponseEntity<Void> =
        boardFacade.checkBoard(modifyBoardWebRequest.toData(boardId))
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @DeleteMapping("/{board_id}")
    fun deleteBoardById(@PathVariable ("board_id") boardId: Long): ResponseEntity<Void> =
        boardFacade.deleteBoardById(boardId)
            .let { ResponseEntity.noContent().build() }


}