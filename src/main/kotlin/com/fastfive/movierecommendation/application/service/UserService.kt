package com.fastfive.movierecommendation.application.service

import com.fastfive.movierecommendation.application.dto.SignInRequestDto
import com.fastfive.movierecommendation.domain.model.user.User
import com.fastfive.movierecommendation.domain.shared.exception.NotFoundMemberException
import com.fastfive.movierecommendation.infrastructure.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun signIn(signInRequestDto: SignInRequestDto): User {
        val user = userRepository.findByEmail(signInRequestDto.email) ?: throw NotFoundMemberException()
        return user
    }
}
