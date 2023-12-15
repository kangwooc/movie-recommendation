package com.fastfive.movierecommendation.application.dto

import com.fastfive.movierecommendation.domain.model.user.Gender

data class CreateUserRequestDto(
    val email: String,
    val password: String,
    val name: String,
    val gender: Gender,
    val age: Int,
)
