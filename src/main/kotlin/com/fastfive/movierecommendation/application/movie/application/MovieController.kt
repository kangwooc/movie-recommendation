package com.fastfive.movierecommendation.application.movie.application

import com.fastfive.movierecommendation.application.movie.dto.*
import com.fastfive.movierecommendation.application.movie.service.MovieService
import jakarta.validation.Valid
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*

@RestController
class MovieController(private val movieService: MovieService) {
    @PostMapping("/movie")
    fun create(@RequestBody @Valid createMovieDto: CreateMovieDto): Boolean {
        val success = movieService.create(createMovieDto)
        return success
    }

    @GetMapping("/movie")
    fun getMovieByTitle(
        @RequestParam title: String,
        @PageableDefault(
            page= 1,
            size= 10,
            sort = ["movieId"],
            direction = Sort.Direction.DESC
        ) pageable: Pageable): List<GetMoviesByCriteriaResponseDto> {
        return movieService.getMoviesByTitle(title, pageable)
    }

    @GetMapping("/movie/{movieId}")
    fun getMovieById(@PathVariable movieId: Long): GetMovieByIdResponseDto = movieService.getMovieById(movieId)

    @PatchMapping("/movie/{movieId}")
    fun updateMovie(
        @PathVariable movieId: Long,
        @RequestBody @Valid updateMovieDto: UpdateMovieDto
    ): Boolean {
        return movieService.updateMovie(movieId, updateMovieDto)
    }
}
