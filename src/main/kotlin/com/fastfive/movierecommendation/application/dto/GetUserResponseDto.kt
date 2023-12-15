package com.fastfive.movierecommendation.application.dto

data class GetUserResponseDto(
    val email: String,
    val name: String,
    val age: Int,
)
