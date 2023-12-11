package com.fastfive.movierecommendation.application.domain.model

import jakarta.persistence.CascadeType.ALL
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Lob
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "movies")
class Movie(
    @Id @GeneratedValue @Column(name = "movie_id")
    var movieId: Long,
    var title: String,
    @Column(name = "release_date")
    var releaseDate: LocalDateTime,
    @Lob
    var description: String,
    var runtime: Int,
    @OneToOne(fetch = LAZY, cascade = [ALL])
    var movieMetaData: MovieMetaData,
) : BaseEntity()
