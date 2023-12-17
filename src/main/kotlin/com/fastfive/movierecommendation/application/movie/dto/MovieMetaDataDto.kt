package com.fastfive.movierecommendation.application.movie.dto

import com.fastfive.movierecommendation.domain.model.movie.Movie
import com.fastfive.movierecommendation.domain.model.movie.MovieMetaData
import java.math.BigInteger

/**
 * DTO for {@link com.fastfive.movierecommendation.domain.model.movie.MovieMetaData}
 */
data class MovieMetaDataDto(
    val keyword: String? = null,
    val productCountry: String? = null,
    val language: String? = null,
    val budget: BigInteger? = null,
    val revenue: BigInteger? = null,
) {
    fun toEntity(movie: Movie): MovieMetaData {
        return MovieMetaData(
            keyword = keyword ?: "",
            budget = budget ?: BigInteger.ZERO,
            revenue = revenue ?: BigInteger.ZERO,
            language = language ?: "",
            productCountry = productCountry ?: "",
            movie = movie,
        )
    }
}
