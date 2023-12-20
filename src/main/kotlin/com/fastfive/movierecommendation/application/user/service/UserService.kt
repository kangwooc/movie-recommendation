package com.fastfive.movierecommendation.application.user.service

import com.fastfive.movierecommendation.application.user.dto.CreateUserRequestDto
import com.fastfive.movierecommendation.application.user.dto.GetUserRequestDto
import com.fastfive.movierecommendation.domain.model.user.User
import com.fastfive.movierecommendation.infrastructure.jpa.repository.user.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    val logger = LoggerFactory.getLogger(UserService::class.java)

    fun getUsers(): List<User> {
        return userRepository.findAll()
    }

    fun getUser(getUserRequestDto: GetUserRequestDto): User? {
        if (getUserRequestDto.email != null) {
            return userRepository.findByEmail(getUserRequestDto.email)
        }
        if (getUserRequestDto.name != null) {
            return userRepository.findByName(getUserRequestDto.name)
        }
        return null
    }

    fun create(createUserRequestDto: CreateUserRequestDto): Boolean {
        val userDao =
            User(
                email = createUserRequestDto.email,
                name = createUserRequestDto.name,
                gender = createUserRequestDto.gender,
                age = createUserRequestDto.age,
            )

        val user = userRepository.save(userDao)
        return user.userId != null
    }
}
