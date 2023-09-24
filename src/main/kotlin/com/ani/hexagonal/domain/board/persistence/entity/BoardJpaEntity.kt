package com.ani.hexagonal.domain.board.persistence.entity

import com.ani.hexagonal.domain.user.persistence.entity.UserJpaEntity
import jakarta.persistence.*

@Entity
@Table(name = "board")
class BoardJpaEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    val id: Long,

    val title: String,

    val content: String,

    @ManyToMany
    @JoinColumn(name = "category_id")
    val category: List<CategoryJpaEntity>,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val writer: UserJpaEntity
)