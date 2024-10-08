package com.fastfive.movierecommendation.domain.model.movie

import com.fastfive.movierecommendation.domain.shared.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Lob
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "cast_member")
class CastMember(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cast_member_id")
    var castMemberId: Long? = null,
    @Column(length = 255)
    var name: String,
    @Column(columnDefinition = "TEXT")
    var bio: String,
    @Column(name = "birthdate")
    var birthDate: LocalDateTime,
) : BaseEntity()
