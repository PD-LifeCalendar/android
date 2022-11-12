package com.example.lifecalendar.domain.model

/*sealed class DtoWrapper<out T> {
    data class Success<out T>(val value: T): DtoWrapper<T>()
    data class GenericError(val code: Int? = null, val error: String? = null): DtoWrapper<Nothing>()
    data class ServerError(val code: Int? = null, val errorMessage: String? = null): DtoWrapper<Nothing>()
    object NetworkError: DtoWrapper<Nothing>()
}*/

sealed class DtoWrapper<T>(val data: T? = null, val errorCode: String? = null) {
    class Success<T>(data: T) : DtoWrapper<T>(data = data)
    class Error<T>(errorCode: String) : DtoWrapper<T>(errorCode = errorCode)
}