package com.example.lifecalendar.domain.model

sealed class ResultWrapper<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : ResultWrapper<T>(data = data)
    class Error<T>(errorMessage: String) : ResultWrapper<T>(message = errorMessage)
}

data class ErrorResponse(
    val status: String,
    val failureMessage: String
)

