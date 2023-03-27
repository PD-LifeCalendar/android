package com.example.lifecalendar.data.source.remote

import com.example.lifecalendar.data.source.remote.model.LoginRequest
import com.example.lifecalendar.data.source.remote.model.LoginResponse
import com.example.lifecalendar.data.source.remote.model.RefreshTokenRequest
import com.example.lifecalendar.data.source.remote.model.RegisterRequest
import retrofit2.Response
import retrofit2.http.*

interface LifeCalendarService {
    
    @POST("/api/v1/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
    
    
    @POST("/api/v1/auth/refresh")
    suspend fun refreshToken(@Header("Cookie") refresh_token: String): Response<LoginResponse>
    
//    @Header("Cookie") refresh_token: String
    
}