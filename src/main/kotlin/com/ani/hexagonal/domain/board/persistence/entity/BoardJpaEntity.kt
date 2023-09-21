package com.ani.hexagonal.domain.board.persistence.entity

import com.ani.hexagonal.domain.user.persistence.entity.UserJpaEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.springframework.data.annotation.Id

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