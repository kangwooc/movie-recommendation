package com.fastfive.movierecommendation.domain.model.movie

import com.fastfive.movierecommendation.domain.shared.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "genres")
class Genre(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    var genreId: Long? = null,
    @Column(length = 255)
    var name: String,
) : BaseEntity()
