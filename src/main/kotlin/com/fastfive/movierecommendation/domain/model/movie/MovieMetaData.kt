package com.fastfive.movierecommendation.domain.model.movie

import com.fastfive.movierecommendation.domain.shared.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.math.BigInteger

@Entity
@Table(name = "movie_metadata")
class MovieMetaData(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_metadata_id")
    var movieMetaDataId: Long? = null,
    var keywords: String,
    @Column(length = 255, name = "production_country")
    var productionCountry: String,
    @Column(length = 100)
    var language: String,
    var budget: BigInteger,
    var revenue: BigInteger,
    @OneToOne(mappedBy = "movieMetaData", fetch = LAZY)
    var movie: Movie,
) : BaseEntity()
