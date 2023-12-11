package com.fastfive.movierecommendation.application.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Lob
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "cast_member")
class CastMember(
    @Id @GeneratedValue @Column(name = "cast_member_id")
    var castMemberId: Long,
    @Column(length = 255)
    var name: String,
    @Lob
    var bio: String,
    @Column(name = "birthdate")
    var birthDate: LocalDateTime,
) : BaseEntity()
