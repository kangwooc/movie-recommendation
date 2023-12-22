package com.fastfive.movierecommendation.presentation

import com.fastfive.movierecommendation.application.movie.dto.CreateMovieDto
import com.fastfive.movierecommendation.application.movie.dto.GetMovieByIdResponseDto
import com.fastfive.movierecommendation.application.movie.dto.GetMoviesByCriteriaResponseDto
import com.fastfive.movierecommendation.application.movie.dto.UpdateMovieDto
import com.fastfive.movierecommendation.application.movie.service.MovieService
import jakarta.validation.Valid
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movie")
class MovieController(private val movieService: MovieService) {
    @PostMapping("/")
    fun create(@RequestBody @Valid createMovieDto: CreateMovieDto): Boolean {
        val success = movieService.create(createMovieDto)
        return success
    }

    @GetMapping("/")
    fun getMoviesByTitle(
        @RequestParam title: String,
        @PageableDefault(
            page= 1,
            size= 10,
            sort = ["movieId"],
            direction = Sort.Direction.DESC
        ) pageable: Pageable): List<GetMoviesByCriteriaResponseDto> {
        return movieService.getMoviesByTitle(title, pageable)
    }

    @GetMapping("/{movieId}")
    fun getMovieById(@PathVariable movieId: Long): GetMovieByIdResponseDto = movieService.getMovieById(movieId)

    @GetMapping("/genre/{genreId}")
    fun getMoviesByGenreId(@PathVariable genreId: Long): List<GetMoviesByCriteriaResponseDto> {
        return movieService.getMoviesByGenre(genreId)
    }

    @PutMapping("/movie/{movieId}")
    fun updateMovie(
        @PathVariable movieId: Long,
        @RequestBody @Valid updateMovieDto: UpdateMovieDto
    ): Boolean {
        return movieService.updateMovie(movieId, updateMovieDto)
    }

    @DeleteMapping("/movie/{movieId}")
    fun deleteMovie(@PathVariable movieId: Long): Boolean {
        return movieService.delete(movieId)
    }
}
