package com.fastfive.movierecommendation.application.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Lob
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "ratings")
class Rating(
    @Id @GeneratedValue
    @Column(name = "rating_id")
    var ratingId: Long,
    @Column(name = "score", precision = 10, scale = 0, columnDefinition = "numeric(2,1)")
    var score: Double,
    @Lob
    var description: String,
    @Column(name = "rating_date")
    var ratingDate: LocalDateTime,
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    var user: User,
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "movie_id")
    var movie: Movie,
) : BaseEntity()
