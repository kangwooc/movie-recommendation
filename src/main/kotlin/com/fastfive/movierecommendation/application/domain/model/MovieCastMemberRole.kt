package com.fastfive.movierecommendation.application.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "movie_cast_member")
class MovieCastMemberRole(
    @Id @GeneratedValue
    @Column(name = "movie_cast_member_id")
    var movieCastMemberRoleId: Long,
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "cast_member_id")
    var castMember: CastMember,
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "role_id")
    var role: Role,
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "movie")
    var movie: Movie,

    ) : BaseEntity()
