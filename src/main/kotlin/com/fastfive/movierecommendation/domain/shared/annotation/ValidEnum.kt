package com.fastfive.movierecommendation.domain.shared.annotation

import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class ValidEnum(val enumClass: KClass<out Enum<*>>)
