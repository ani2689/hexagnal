package com.ani.hexagonal.domain.user.persistence.entity

import com.ani.hexagonal.domain.user.application.model.role.UserRole
import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.UUID

@Entity
@Table(name = "user")
class UserJpaEntity(
    @Id @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "user_id")
    val id: UUID = UUID.randomUUID(),

    @Column(length = 10, nullable = false)
    val name: String = "",

    @Column(nullable = false)
    val email: String = "",

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "roles", joinColumns = [JoinColumn(name = "user_id")])
    var role: MutableList<UserRole> = mutableListOf()
)
