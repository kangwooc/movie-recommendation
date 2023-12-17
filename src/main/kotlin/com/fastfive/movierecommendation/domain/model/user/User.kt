package com.fastfive.movierecommendation.domain.model.user

import com.fastfive.movierecommendation.domain.shared.BaseEntity
import jakarta.persistence.CascadeType.ALL
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(
    name = "users",
)
class User(name: String, email: String, gender: String, age: Int) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    var userId: Long? = null

    @Column(length = 255, nullable = false)
    var name: String = name

    @Column(unique = true, length = 255)
    var email: String = email

    @Enumerated(EnumType.STRING)
    var gender: Gender = Gender.valueOf(gender)

    var age: Int = age

    @Column(name = "join_date")
    var joinDate: LocalDate = LocalDate.now()

    @OneToMany(mappedBy = "user", cascade = [ALL])
    val userGenre: List<UserGenre> = arrayListOf<UserGenre>()
}
