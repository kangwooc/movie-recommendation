package com.fastfive.movierecommendation.domain.model.user

import com.fastfive.movierecommendation.domain.model.movie.Genre
import com.fastfive.movierecommendation.domain.shared.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "users_genre")
class UserGenre(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_genre_id")
    val id: Long? = null,
    @ManyToOne(fetch = LAZY)
    val user: User,
    @ManyToOne(fetch = LAZY)
    val genre: Genre,
) : BaseEntity()
