package com.fastfive.movierecommendation.application.user.dto

import com.fastfive.movierecommendation.domain.model.user.Gender
import com.fastfive.movierecommendation.domain.shared.annotation.ValidEnum

data class CreateUserRequestDto(
    val email: String,
    val password: String,
    val name: String,
    @ValidEnum(enumClass = Gender::class)
    val gender: String,
    val age: Int,
)
