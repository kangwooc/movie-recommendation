package com.fastfive.movierecommendation.infrastructure.jpa.repository.movie

import com.fastfive.movierecommendation.domain.model.movie.Movie
import org.springframework.data.jpa.repository.JpaRepository

interface MovieRepository : JpaRepository<Movie, Long> {
//    fun updateMovie(dto: UpdateMovieDto)
}
