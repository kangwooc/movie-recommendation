package com.fastfive.movierecommendation.application.service

import com.fastfive.movierecommendation.application.dto.CreateUserRequestDto
import com.fastfive.movierecommendation.application.dto.GetUserRequestDto
import com.fastfive.movierecommendation.domain.model.user.User
import com.fastfive.movierecommendation.domain.shared.exception.NotFoundMemberException
import com.fastfive.movierecommendation.infrastructure.jpa.repository.user.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun getUsers(): List<User> {
        return userRepository.findAll()
    }

    fun getUser(getUserRequestDto: GetUserRequestDto): User {
        val user = userRepository.findByEmail(getUserRequestDto.email) ?: throw NotFoundMemberException()
        return user
    }

    fun create(createUserRequestDto: CreateUserRequestDto): Boolean {
        val userDao = User(email = createUserRequestDto.email, name = createUserRequestDto.name, gender = createUserRequestDto.gender ,age = createUserRequestDto.age)
        val user = userRepository.save(userDao)
        return user.userId != null
    }
}
