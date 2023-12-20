package com.fastfive.movierecommendation.domain.shared.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundMovieException: MovieException(errorCode = ErrorCode.ERRM001)
