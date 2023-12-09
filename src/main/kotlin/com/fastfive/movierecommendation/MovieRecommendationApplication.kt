package com.fastfive.movierecommendation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class MovieRecommendationApplication

fun main(args: Array<String>) {
    runApplication<MovieRecommendationApplication>(*args)
}
