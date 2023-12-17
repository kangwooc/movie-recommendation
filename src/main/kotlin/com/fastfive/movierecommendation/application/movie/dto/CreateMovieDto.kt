package com.fastfive.movierecommendation.application.movie.dto

import com.fastfive.movierecommendation.domain.model.movie.Movie
import java.time.LocalDateTime

/**
 * DTO for {@link com.fastfive.movierecommendation.domain.model.movie.Movie}
 */
class CreateMovieDto private constructor(
    val title: String,
    val releaseDate: LocalDateTime,
    val description: String,
    val runtime: Int,
) {
    fun toEntity(): Movie {
        val movie =
            Movie(
                title = title,
                releaseDate = releaseDate,
                description = description,
                runtime = runtime,
            )
        val movieMetaData =
            return movie
    }
}
