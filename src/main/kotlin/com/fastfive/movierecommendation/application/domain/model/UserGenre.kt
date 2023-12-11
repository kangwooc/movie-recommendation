package com.fastfive.movierecommendation.application.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "users_genre")
class UserGenre(
    @Id @GeneratedValue
    @Column(name = "user_genre_id")
    val id: Long,
    @ManyToOne(fetch = LAZY)
    val user: User,
    @ManyToOne(fetch = LAZY)
    val genre: Genre,
) : BaseEntity()
