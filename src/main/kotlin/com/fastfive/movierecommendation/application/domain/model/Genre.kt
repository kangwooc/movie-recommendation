package com.fastfive.movierecommendation.application.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "genres")
class Genre(
    @Id @GeneratedValue
    @Column(name = "genre_id")
    var genreId: Long,
    @Column(length = 255)
    var name: String,
) : BaseEntity()
