package com.fastfive.movierecommendation.application.controller

import com.fastfive.movierecommendation.application.dto.CreateUserRequestDto
import com.fastfive.movierecommendation.application.dto.CreateUserResponseDto
import com.fastfive.movierecommendation.application.dto.GetUserRequestDto
import com.fastfive.movierecommendation.application.dto.GetUserResponseDto
import com.fastfive.movierecommendation.application.service.UserService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val userService: UserService) {
    @GetMapping("/user")
    fun getUser(
        @RequestParam @Valid getUserRequestDto: GetUserRequestDto,
    ): GetUserResponseDto {
        val user = userService.getUser(getUserRequestDto)
        return GetUserResponseDto(email = user.email, name = user.name, age = user.age)
    }

    @GetMapping("/user/list")
    fun getUsers(): List<GetUserResponseDto> {
        val users = userService.getUsers()
        return users.map { GetUserResponseDto(email = it.email, name = it.name, age = it.age) }
    }

    @PostMapping("/user")
    fun create(@RequestBody @Valid createUserRequestDto: CreateUserRequestDto): CreateUserResponseDto {
        val success = userService.create(createUserRequestDto)
        return CreateUserResponseDto(success = success)
    }
}
