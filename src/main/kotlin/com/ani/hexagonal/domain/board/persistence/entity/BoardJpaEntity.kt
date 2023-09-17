package com.ani.hexagonal.domain.board.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToMany
import org.springframework.data.annotation.Id

@Entity
data class BoardJpaEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    val id: Long,
    val title: String,
    val content: String,
    @ManyToMany
    @JoinColumn(name = "categories_id")
    val categories: MutableList<CategoryJpaEntity>
)