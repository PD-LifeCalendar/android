package com.example.lifecalendar.data.source.remote

import com.example.lifecalendar.data.source.remote.model.LoginRequest
import com.example.lifecalendar.data.source.remote.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LifeCalendarService {
    
    @FormUrlEncoded
    @POST("/life-calendar/api/v1/auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Response<LoginResponse>
    
    
//    @POST("/api/v1/auth/login")
//    suspend fun login(@Body requset: LoginRequest): Response<LoginResponse>
}