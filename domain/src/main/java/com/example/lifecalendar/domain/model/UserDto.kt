package com.example.lifecalendar.domain.model

data class UserDto(
    val email: String,
    val name: String,
    val birthdate: String,
    val description: String,
    val sex: String,
    val role: String,
)
