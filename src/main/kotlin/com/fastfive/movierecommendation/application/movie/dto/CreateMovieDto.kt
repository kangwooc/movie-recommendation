package com.fastfive.movierecommendation.application.movie.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fastfive.movierecommendation.domain.model.movie.Movie
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * DTO for {@link com.fastfive.movierecommendation.domain.model.movie.Movie}
 */
class CreateMovieDto (
    val title: String,
    val releaseDate: LocalDate,
    val description: String,
    val runtime: Int,
    val movieMetaData: MovieMetaDataDto? = null,
) {
    fun toEntity(): Movie {
        val movie = Movie(
                title = title,
                releaseDate = releaseDate,
                description = description,
                runtime = runtime,
            )
        // 양방향 체크
        val movieMetaData = movieMetaData?.toEntity(movie)
        movie.movieMetaData = movieMetaData
        return movie
    }
}
