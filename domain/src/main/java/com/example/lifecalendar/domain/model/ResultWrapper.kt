package com.example.lifecalendar.domain.model

sealed class ResultWrapper<T>(val data: T? = null, val message: String? = null, val cookies: String? = null) {
    class Success<T>(data: T, cookies: String) : ResultWrapper<T>(data = data, cookies = cookies)
    class Error<T>(errorMessage: String) : ResultWrapper<T>(message = errorMessage)
}

data class ErrorResponse(
    val status: String,
    val failureMessage: String
)

