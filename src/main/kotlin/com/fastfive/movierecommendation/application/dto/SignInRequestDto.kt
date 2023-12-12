package com.fastfive.movierecommendation.application.dto

import jakarta.validation.constraints.NotBlank

data class SignInRequestDto(
    @NotBlank
    val email: String,
    @NotBlank
    val password: String,
)
