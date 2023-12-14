package com.fastfive.movierecommendation.domain.model.recommendation

import com.fastfive.movierecommendation.domain.model.movie.Movie
import com.fastfive.movierecommendation.domain.model.user.User
import com.fastfive.movierecommendation.domain.shared.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "recommendations")
class Recommendation(
    @Id @GeneratedValue
    @Column(name = "recommendation_id")
    var recommendationId: Long? = null,
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    var user: User,
    @OneToMany
    var movies: List<Movie> = arrayListOf<Movie>(),
    @Column(name = "recommendation_date")
    var recommendationDate: LocalDateTime,
) : BaseEntity()
