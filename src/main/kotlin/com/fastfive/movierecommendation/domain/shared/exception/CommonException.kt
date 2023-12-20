package com.fastfive.movierecommendation.domain.shared.exception

open class CommonException : RuntimeException()

open class MemberException(val errorCode: ErrorCode) : CommonException()
open class MovieException(val errorCode: ErrorCode) : CommonException()

enum class ErrorCode(val code: String, val message: String) {
    ERR000("ERR000", "알 수 없는 에러가 발생했습니다."),
    ERR001("ERR001", "해당 회원이 존재하지 않습니다."),
    ERR002("ERR002", "이미 가입한 이메일 입니다."),
    ERRM000("ERRM000", "알 수 없는 에러가 발생했습니다."),
    ERRM001("ERRM001", "해당 영화가 존재하지 않습니다."),
}
