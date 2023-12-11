package com.fastfive.movierecommendation.application.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "recommendations")
class Recommendation(
    @Id @GeneratedValue
    @Column(name = "recommendation_id")
    var id: Long,
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    var user: User,
    @Column(name = "recommendation_date")
    var recommendationDate: LocalDateTime,
) : BaseEntity()
