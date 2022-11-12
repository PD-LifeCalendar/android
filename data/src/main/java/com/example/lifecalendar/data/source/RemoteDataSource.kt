package com.example.lifecalendar.data.source

import com.example.lifecalendar.data.source.remote.LifeCalendarService
import com.example.lifecalendar.data.source.remote.model.LoginRequest
import com.example.lifecalendar.data.source.remote.model.LoginResponse
import com.example.lifecalendar.data.source.remote.model.ResponseWrapper
import com.example.lifecalendar.data.util.SafeApiCall
import retrofit2.Response

class RemoteDataSource(private val api: LifeCalendarService) : SafeApiCall() {
    
    suspend fun login(loginRequest: LoginRequest): ResponseWrapper<LoginResponse> {
        return safeApiCall { api.login(loginRequest.email, loginRequest.password) }
    }
}