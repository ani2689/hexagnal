package com.ani.hexagonal.domain.board.application.model

import com.ani.hexagonal.domain.user.application.model.User

class Board (
    val id: Long,
    val title: String,
    val content: String,
    val category: List<Category>,
    val writer: User
)