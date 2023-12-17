package com.fastfive.movierecommendation.application.user.dto

data class CreateUserResponseDto(
    val success: Boolean,
    val message: String = "user created!",
)
