package com.example.lifecalendar.data.repository

import com.example.lifecalendar.data.mapper.AuthDtoMapper
import com.example.lifecalendar.data.source.RemoteDataSource
import com.example.lifecalendar.data.source.local.SessionManager
import com.example.lifecalendar.data.source.remote.model.ResponseWrapper
import com.example.lifecalendar.domain.model.DtoWrapper
import com.example.lifecalendar.domain.model.LoginDto
import com.example.lifecalendar.domain.model.UserDto
import com.example.lifecalendar.domain.repository.AuthorizationRepository

class AuthorizationRepositoryImpl(
    private val remoteDataSource: RemoteDataSource, private val sessionManager: SessionManager
) : AuthorizationRepository {
    
    override suspend fun login(loginDto: LoginDto): DtoWrapper<UserDto> {
        val loginRequest = AuthDtoMapper.mapLoginDtoToRequest(loginDto)
        return when (val responseWrapper = remoteDataSource.login(loginRequest)) {
            is ResponseWrapper.Error -> DtoWrapper.Error("")
            is ResponseWrapper.Success -> {
                val loginResponse = responseWrapper.data
                if (loginResponse != null) {
                    sessionManager.saveAuthToken(loginResponse.accessToken)
                    val userDto =
                        AuthDtoMapper.mapLoginResponseToUserDto(loginResponse.userRegistrationResponse)
                    DtoWrapper.Success(userDto)
                } else {
                    //TODO: 
                    DtoWrapper.Error("Что то пошло не так")
                }
//                DtoWrapper.Success(userDto)
            }
        }
        
        /*return when (val responseWrapper = remoteDataSource.login(loginRequest)) {
            is ResponseWrapper.NetworkError -> {
                Log.d("result_wrap_rep_tag", "NetworkError")
                return DtoWrapper.NetworkError
            }
            is ResponseWrapper.GenericError -> {
                Log.d("result_wrap_rep_tag", "GenericError")
                return DtoWrapper.GenericError()
            }
            is ResponseWrapper.Success -> {
                Log.d("result_wrap_rep_tag", "Success")
                if (responseWrapper.value.isSuccessful) {
                    responseWrapper.value.body()?.let { loginResponse ->
                        Log.d("result_wrap_rep_tag1", "Success")
                        sessionManager.saveAuthToken(loginResponse.accessToken)
                        val userDto =
                            AuthDtoMapper.mapLoginResponseToUserDto(loginResponse.userRegistrationResponse)
                        return DtoWrapper.Success(userDto)
                    }
                } else {
                    val code = responseWrapper.value.code()
                    return DtoWrapper.ServerError(code)
                }
            }
        }*/
    }
}