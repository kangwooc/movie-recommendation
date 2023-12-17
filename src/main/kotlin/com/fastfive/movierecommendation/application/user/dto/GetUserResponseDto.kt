package com.fastfive.movierecommendation.application.user.dto

data class GetUserResponseDto(
    val email: String,
    val name: String,
    val age: Int,
)
