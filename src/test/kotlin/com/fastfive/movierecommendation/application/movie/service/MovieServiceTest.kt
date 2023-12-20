package com.fastfive.movierecommendation.application.movie.service

import com.fastfive.movierecommendation.application.movie.dto.CreateMovieDto
import com.fastfive.movierecommendation.infrastructure.jpa.repository.movie.MovieRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.mockk
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

private val mockMovieRepository: MovieRepository = mockk()

@InjectMockKs
val mockMovieService: MovieService = MovieService(mockMovieRepository)


@SpringBootTest
class MovieServiceTest: BehaviorSpec({
    given("영화 생성") {
        `when`("create a movie") {
            val dto = CreateMovieDto(
                title = "title",
                releaseDate = LocalDate.now(),
                description = "description",
                runtime = 90,
            )
            val result = mockMovieService.create(dto)
            then("should return true") {
                result shouldBe true
            }
        }
    }
})
