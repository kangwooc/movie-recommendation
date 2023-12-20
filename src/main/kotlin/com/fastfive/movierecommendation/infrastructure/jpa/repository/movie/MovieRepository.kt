package com.fastfive.movierecommendation.infrastructure.jpa.repository.movie

import com.fastfive.movierecommendation.domain.model.movie.Movie
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface MovieRepository : JpaRepository<Movie, Long> {
    fun findByTitleContaining(title: String, pageable: Pageable): Page<Movie>
}
