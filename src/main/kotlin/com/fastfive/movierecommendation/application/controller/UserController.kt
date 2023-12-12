package com.fastfive.movierecommendation.application.controller

import com.fastfive.movierecommendation.application.dto.SignInRequestDto
import com.fastfive.movierecommendation.application.dto.SignInResponseDto
import com.fastfive.movierecommendation.application.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val userService: UserService) {
    @GetMapping("/signin")
    fun login(
        @RequestBody signInRequestDto: SignInRequestDto,
    ): SignInResponseDto {
        val user = userService.signIn(signInRequestDto)
        return SignInResponseDto(success = true, email = user.email)
    }
}
