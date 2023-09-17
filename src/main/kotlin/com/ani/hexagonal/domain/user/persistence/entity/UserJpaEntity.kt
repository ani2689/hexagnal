package com.ani.hexagonal.domain.user.persistence.entity

import com.ani.hexagonal.domain.board.persistence.entity.BoardJpaEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.annotations.GenericGenerator
import java.util.UUID

@Entity
@Table(name = "user")
class UserJpaEntity(
    @Id @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "user_id")
    val id: UUID,

    @Column(length = 10, nullable = false)
    val name: String,

    @Column(nullable = false)
    val email: String,

    @ManyToMany
    @JoinColumn(name = "board_id")
    val boards: List<BoardJpaEntity>
)
