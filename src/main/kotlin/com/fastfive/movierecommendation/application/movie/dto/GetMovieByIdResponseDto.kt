package com.fastfive.movierecommendation.application.movie.dto

import com.fastfive.movierecommendation.domain.model.movie.Movie

class GetMovieByIdResponseDto(
    var movieId: Long? = null,
    var title: String? = null,
    var releaseDate: String? = null,
    var description: String? = null,
    var runtime: Int? = null,
) {
    fun fromEntity(movie: Movie): GetMovieByIdResponseDto {
        return GetMovieByIdResponseDto(
            movieId = movie.movieId,
            title = movie.title,
            releaseDate = movie.releaseDate.toString(),
            description = movie.description,
            runtime = movie.runtime,
        )
    }
}
