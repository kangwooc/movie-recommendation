package com.fastfive.movierecommendation.infrastructure.jpa.repository.user

import com.fastfive.movierecommendation.domain.model.user.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository: JpaRepository<User, Long>, UserRepositoryWithCustomMethods {
    fun findByName(name: String): User?
    fun existsByName(name: String): Boolean
    fun findByEmail(email: String): User?
}

interface UserRepositoryWithCustomMethods {

}
