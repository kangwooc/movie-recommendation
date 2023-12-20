package com.fastfive.movierecommendation.application.user.presentation

import com.fastfive.movierecommendation.application.user.dto.CreateUserRequestDto
import com.fastfive.movierecommendation.application.user.dto.CreateUserResponseDto
import com.fastfive.movierecommendation.application.user.dto.GetUserRequestDto
import com.fastfive.movierecommendation.application.user.dto.GetUserResponseDto
import com.fastfive.movierecommendation.application.user.service.UserService
import com.fastfive.movierecommendation.domain.shared.exception.NotFoundMemberException
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @GetMapping("/")
    fun getUser(getUserRequestDto: GetUserRequestDto): GetUserResponseDto {
        val user = userService.getUser(getUserRequestDto) ?: throw NotFoundMemberException()
        return GetUserResponseDto(email = user.email, name = user.name, age = user.age)
    }

    @GetMapping("/list")
    fun getUsers(): List<GetUserResponseDto> {
        val users = userService.getUsers()
        return users.map { GetUserResponseDto(email = it.email, name = it.name, age = it.age) }
    }

    @PostMapping("/")
    fun create(
        @RequestBody @Valid createUserRequestDto: CreateUserRequestDto,
    ): CreateUserResponseDto {
        val success = userService.create(createUserRequestDto)
        return CreateUserResponseDto(success = success)
    }
}
