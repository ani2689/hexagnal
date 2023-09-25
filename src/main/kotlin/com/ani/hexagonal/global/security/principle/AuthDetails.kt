package com.ani.hexagonal.global.security.principle

import com.ani.hexagonal.domain.user.persistence.entity.UserJpaEntity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthDetails(
    private val user: UserJpaEntity
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> =
        user.role

    override fun getPassword(): String? = null

    override fun getUsername(): String =
        user.id.toString()

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}