package com.ani.hexagonal.domain.board.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "category")
class CategoryJpaEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    val id: Long,

    val name: String
)