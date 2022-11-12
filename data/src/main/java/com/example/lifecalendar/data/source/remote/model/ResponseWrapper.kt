package com.example.lifecalendar.data.source.remote.model

import com.google.gson.annotations.SerializedName

sealed class ResponseWrapper<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : ResponseWrapper<T>(data = data)
    class Error<T>(errorMessage: String) : ResponseWrapper<T>(message = errorMessage)
}

/*sealed class ResponseWrapper<out T> {
    data class Success<out T>(val value: T): ResponseWrapper<T>()
    data class GenericError(val code: Int? = null, val error: ErrorResponse? = null): ResponseWrapper<Nothing>()
    object NetworkError: ResponseWrapper<Nothing>()
}*/

/*data class ErrorResponse(
    val error_description: String, // this is the translated error shown to the user directly from the API
    val causes: Map<String, String> = emptyMap() //this is for errors on specific field on a form
)*/

data class ErrorResponse(
    val status: String,
    
    @SerializedName("failure_message")
    val failureMessage: String
)

