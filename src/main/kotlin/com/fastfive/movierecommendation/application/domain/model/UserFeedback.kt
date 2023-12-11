package com.fastfive.movierecommendation.application.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Lob
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "user_feedback")
class UserFeedback(
    @Id @GeneratedValue
    @Column(name = "user_feedback_id")
    var id: Long,
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    var user: User,
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "movie_id")
    var movie: Movie,
    @Lob
    var feedback: String,
    @Column(name = "feedback_date")
    var feedbackDate: LocalDateTime,
)
