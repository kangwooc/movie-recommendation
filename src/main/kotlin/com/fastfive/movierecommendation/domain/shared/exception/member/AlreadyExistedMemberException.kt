package com.fastfive.movierecommendation.domain.shared.exception.member

import com.fastfive.movierecommendation.domain.shared.exception.ErrorCode
import com.fastfive.movierecommendation.domain.shared.exception.MemberException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.CONFLICT)
class AlreadyExistedMemberException: MemberException(errorCode = ErrorCode.ERR002)
