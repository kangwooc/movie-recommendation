package com.fastfive.movierecommendation.application.user.service

import com.fastfive.movierecommendation.infrastructure.jpa.repository.user.UserRepository
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.mockk
import org.springframework.boot.test.context.SpringBootTest

private val mockUserRepository: UserRepository = mockk()

@InjectMockKs
val mockUserService: UserService = UserService(mockUserRepository)
@SpringBootTest
internal class UserServiceTest {

}
