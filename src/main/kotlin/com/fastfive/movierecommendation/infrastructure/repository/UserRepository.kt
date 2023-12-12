package com.fastfive.movierecommendation.infrastructure.repository

import com.fastfive.movierecommendation.domain.model.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}
