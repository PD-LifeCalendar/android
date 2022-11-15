package com.example.lifecalendar.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    val accessToken: String,
    @SerializedName("user") val userRegistrationResponse: UserRegistrationResponse,
)

data class UserRegistrationResponse(
    val email: String,
    val name: String,
    val birthdate: String,
    val description: String?,
    val sex: String,
    val role: String,
)