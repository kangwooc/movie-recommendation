package com.fastfive.movierecommendation.application.movie.dto

import com.fastfive.movierecommendation.domain.model.movie.Movie
import com.fastfive.movierecommendation.domain.model.movie.MovieMetaData

class GetMoviesByCriteriaResponseDto() {
    var id: Long? = null
    var title: String? = null
    var description: String? = null
    var releaseDate: String? = null
    var movieMetaData: MovieMetaData? = null

    fun fromEntity(movies: List<Movie>): List<GetMoviesByCriteriaResponseDto> {
        return movies.map {
            val dto = GetMoviesByCriteriaResponseDto()
            dto.id = it.movieId
            dto.title = it.title
            dto.description = it.description
            dto.releaseDate = it.releaseDate.toString()
            dto.movieMetaData = it.movieMetaData
            dto
        }
    }
}
