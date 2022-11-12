package com.example.lifecalendar.data.source.remote.model

data class LoginResponse(
    val accessToken: String,
    val userRegistrationResponse: UserRegistrationResponse,
)

data class UserRegistrationResponse(
    val email: String,
    val name: String,
    val birthdate: String,
    val sex: String,
    val role: String,
)