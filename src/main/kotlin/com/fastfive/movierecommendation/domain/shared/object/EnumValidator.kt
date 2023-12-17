package com.fastfive.movierecommendation.domain.shared.`object`

import kotlin.reflect.KClass

object EnumValidator {
    fun isValid(
        value: String,
        enumClass: KClass<out Enum<*>>,
    ): Boolean {
        return enumClass.java.enumConstants.any { it.name.equals(value, ignoreCase = true) }
    }
}
