package com.fastfive.movierecommendation.domain.model.movie

import com.fastfive.movierecommendation.domain.shared.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "genres_movies")
class GenresMovies(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genres_movies_id")
    var genreMovieId: Long? = null,
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "genre_id")
    var genre: Genre,
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "movie_id")
    var movie: Movie,
) : BaseEntity()
