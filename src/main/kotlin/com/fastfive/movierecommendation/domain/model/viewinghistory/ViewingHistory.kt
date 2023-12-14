package com.fastfive.movierecommendation.domain.model.viewinghistory

import com.fastfive.movierecommendation.domain.model.movie.Movie
import com.fastfive.movierecommendation.domain.model.user.User
import com.fastfive.movierecommendation.domain.shared.BaseEntity
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
@Table(name = "viewing_history")
class ViewingHistory(
    @Id @GeneratedValue
    @Column(name = "history_id")
    var historyId: Long? = null,
    @Column(name = "view_date")
    var viewDate: LocalDateTime,
    @Column(name = "view_duration")
    var viewDuration: Long,
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    var user: User,
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "movie_id")
    var movie: Movie,
) : BaseEntity()
