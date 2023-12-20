package com.fastfive.movierecommendation.application.movie.service

import com.fastfive.movierecommendation.application.movie.dto.CreateMovieDto
import com.fastfive.movierecommendation.application.movie.dto.GetMovieByIdResponseDto
import com.fastfive.movierecommendation.application.movie.dto.GetMoviesByCriteriaResponseDto
import com.fastfive.movierecommendation.application.movie.dto.UpdateMovieDto
import com.fastfive.movierecommendation.domain.shared.exception.NotFoundMovieException
import com.fastfive.movierecommendation.infrastructure.jpa.repository.movie.MovieRepository
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
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

    fun getMoviesByTitle(title: String, pageable: Pageable): List<GetMoviesByCriteriaResponseDto> {
        try {
            val movies = movieRepository.findByTitleContaining(title, pageable)
            return GetMoviesByCriteriaResponseDto().fromEntity(movies.content)
        } catch (e: Exception) {
            throw e
        }
    }

    fun updateMovie(movieId: Long, updateMovieDto: UpdateMovieDto): Boolean {
        var movie = movieRepository.findByIdOrNull(movieId) ?: throw NotFoundMovieException()
        try {
            updateMovieDto.toEntity(movie)
            movieRepository.save(movie)
            return true
        } catch (e: Exception) {
            throw e
        }
    }

    fun getMovieById(movieId: Long): GetMovieByIdResponseDto {
        val movie = movieRepository.findByIdOrNull(movieId) ?: throw NotFoundMovieException()
        return GetMovieByIdResponseDto().fromEntity(movie)
    }
}
