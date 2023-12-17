package com.fastfive.movierecommendation.application.movie.service

import com.fastfive.movierecommendation.application.movie.dto.CreateMovieDto
import com.fastfive.movierecommendation.infrastructure.jpa.repository.movie.MovieRepository
import org.springframework.stereotype.Service

@Service
class MovieService(private val movieRepository: MovieRepository) {
    fun create(createMovieDto: CreateMovieDto): Boolean {
        try {
            val movie = createMovieDto.toEntity()
            movieRepository.save(movie)
            return true
        } catch (e: Exception) {
            throw e
        }
    }
}
