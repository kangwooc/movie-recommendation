package com.fastfive.movierecommendation.application.movie.dto

import java.time.LocalDateTime

data class UpdateMovieDto(
    val movieId: Long? = null,
    val title: String? = null,
    val releaseDate: LocalDateTime? = null,
    val description: String? = null,
    val runtime: Int? = null,
)
