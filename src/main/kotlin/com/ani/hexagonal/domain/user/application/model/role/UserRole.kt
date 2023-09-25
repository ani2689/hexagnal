package com.ani.hexagonal.domain.user.application.model.role

import org.springframework.security.core.GrantedAuthority

enum class UserRole : GrantedAuthority {
    ROLE_MEMBER, ROLE_ADMIN;
    override fun getAuthority(): String = name
}