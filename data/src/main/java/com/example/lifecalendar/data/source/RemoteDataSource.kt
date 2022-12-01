package com.example.lifecalendar.data.source

import com.example.lifecalendar.data.source.remote.LifeCalendarService
import com.example.lifecalendar.data.source.remote.model.LoginRequest
import com.example.lifecalendar.data.source.remote.model.LoginResponse
import com.example.lifecalendar.data.util.SafeApiCall
import com.example.lifecalendar.domain.model.ResultWrapper

class RemoteDataSource(private val api: LifeCalendarService) : SafeApiCall() {
    
    suspend fun login(loginRequest: LoginRequest): ResultWrapper<LoginResponse> {
        return safeApiCall { api.login(loginRequest) }
    }
    
    suspend fun refreshToken(): ResultWrapper<LoginResponse> {
        return safeApiCall { api.refreshToken() }
    }
}