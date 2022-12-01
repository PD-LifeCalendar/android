package com.example.lifecalendar.data.repository

import com.example.lifecalendar.data.mapper.AuthDtoMapper
import com.example.lifecalendar.data.source.RemoteDataSource
import com.example.lifecalendar.data.source.local.SessionManager
import com.example.lifecalendar.data.source.remote.model.LoginResponse
import com.example.lifecalendar.domain.model.LoginDto
import com.example.lifecalendar.domain.model.ResultWrapper
import com.example.lifecalendar.domain.model.UserDto
import com.example.lifecalendar.domain.repository.AuthorizationRepository

class AuthorizationRepositoryImpl(
    private val remoteDataSource: RemoteDataSource, private val sessionManager: SessionManager
) : AuthorizationRepository {
    
    override suspend fun login(loginDto: LoginDto): ResultWrapper<UserDto> {
        val loginRequest = AuthDtoMapper.mapLoginDtoToRequest(loginDto)
        return caseResultWrapper(remoteDataSource.login(loginRequest))
    }
    
    override suspend fun refreshToken(): ResultWrapper<UserDto> {
        return caseResultWrapper(remoteDataSource.refreshToken())
    }
    
    private fun caseResultWrapper(responseWrapper: ResultWrapper<LoginResponse>): ResultWrapper<UserDto> {
        return when (responseWrapper) {
            is ResultWrapper.Error -> ResultWrapper.Error(responseWrapper.message.toString())
            is ResultWrapper.Success -> {
                val loginResponse = responseWrapper.data
                if (loginResponse != null) {
                    sessionManager.saveAuthToken(loginResponse.accessToken)
                    val userDto =
                        AuthDtoMapper.mapLoginResponseToUserDto(loginResponse.userRegistrationResponse)
                    ResultWrapper.Success(userDto)
                } else {
                    ResultWrapper.Error("Что то пошло не так")
                }
            }
        }
    }
}