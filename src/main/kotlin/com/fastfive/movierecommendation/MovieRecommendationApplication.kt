package com.fastfive.movierecommendation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MovieRecommendationApplication

fun main(args: Array<String>) {
    runApplication<MovieRecommendationApplication>(*args)
}
