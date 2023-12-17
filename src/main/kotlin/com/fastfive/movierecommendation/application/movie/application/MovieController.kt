package com.fastfive.movierecommendation.application.movie.application

import com.fastfive.movierecommendation.application.movie.dto.CreateMovieDto
import com.fastfive.movierecommendation.application.movie.service.MovieService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MovieController(private val movieService: MovieService) {
    @PostMapping("/movie")
    fun create(createMovieDto: CreateMovieDto): Boolean {
        val success = movieService.create(createMovieDto)
        return success
    }
}
