package com.example.lifecalendar.data.source.remote.model

data class RegisterRequest(
    val email: String,
    val name: String,
    val password: String,
    val description: String?,
    val birthdate: String,
    val sex: String,
)
