package com.fastfive.movierecommendation.infrastructure.jpa.repository.movie

import com.fastfive.movierecommendation.domain.model.movie.Movie
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface MovieRepository : JpaRepository<Movie, Long> {
    fun findByTitleContaining(title: String, pageable: Pageable): Page<Movie>
    @Query("SELECT DISTINCT m FROM Movie m " +
        "JOIN fetch m.genresMovies gm " +
        "JOIN fetch gm.genre g " +
        "WHERE g.genreId = :genreId")
    fun findByGenreId(genreId: Long): List<Movie>
}
