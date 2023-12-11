package com.fastfive.movierecommendation.application.domain.model

import jakarta.persistence.CascadeType.ALL
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(
    name = "users",
)
class User(
    @Id @GeneratedValue
    @Column(name = "user_id")
    var userId: Long,
    @Column(length = 255)
    var name: String,
    @Column(unique = true, length = 255)
    var email: String,
    @Enumerated(EnumType.STRING)
    var gender: Gender,
    var age: Int,
    @OneToMany(mappedBy = "user", cascade = [ALL])
    val userGenre: List<UserGenre> = arrayListOf<UserGenre>(),
) : BaseEntity()
