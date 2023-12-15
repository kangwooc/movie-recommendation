package com.fastfive.movierecommendation.application.dto

import jakarta.validation.constraints.NotBlank

data class GetUserRequestDto(
    @NotBlank
    val email: String,
    @NotBlank
    val password: String,
)
