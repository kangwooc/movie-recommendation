package com.fastfive.movierecommendation.application.movie.dto

import com.fastfive.movierecommendation.domain.model.movie.Movie
import java.time.LocalDate

data class UpdateMovieDto(
    val title: String? = null,
    val releaseDate: LocalDate? = null,
    val description: String? = null,
    val runtime: Int? = null,
) {
    fun toEntity(movie: Movie): Movie {
        movie.title = title ?: movie.title
        movie.releaseDate = releaseDate ?: movie.releaseDate
        movie.description = description ?: movie.description
        movie.runtime = runtime ?: movie.runtime
        return movie
    }
}
