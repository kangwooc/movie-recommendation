package com.fastfive.movierecommendation.domain.model.movie

import com.fastfive.movierecommendation.domain.shared.BaseEntity
import jakarta.persistence.CascadeType.ALL
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Lob
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "movies")
class Movie(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    var movieId: Long? = null,
    var title: String,
    @Column(name = "release_date")
    var releaseDate: LocalDate,
    @Column(columnDefinition="TEXT")
    var description: String,
    var runtime: Int,
    @OneToOne(fetch = LAZY, cascade = [ALL])
    @JoinColumn(name = "movie_metadata_id")
    var movieMetaData: MovieMetaData? = null,
) : BaseEntity()
