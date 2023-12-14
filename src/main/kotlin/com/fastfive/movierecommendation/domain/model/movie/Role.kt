package com.fastfive.movierecommendation.domain.model.movie

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Role(
    @Id @GeneratedValue
    @Column(name = "role_id")
    var id: Long? = null,
    @Column(length = 255)
    var name: String,
)
