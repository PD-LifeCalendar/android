package com.example.lifecalendar.data.util

import com.example.lifecalendar.data.source.remote.model.ErrorResponse
import com.example.lifecalendar.data.source.remote.model.ResponseWrapper
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

abstract class SafeApiCall {

/*
    suspend fun <T> safeApiCall(apiCall: suspend () -> T): ResponseWrapper<T> {
        return withContext(Dispatchers.IO) {
            try {
                ResponseWrapper.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is IOException -> ResponseWrapper.NetworkError
                    is HttpException -> {
                        val code = throwable.code()
                        val errorResponse = convertErrorBody(throwable)
                        ResponseWrapper.GenericError(code, errorResponse)
                    }
                    else -> {
                        ResponseWrapper.GenericError(null, null)
                    }
                }
            }
        }
    }
    
    private fun convertErrorBody(throwable: HttpException): ErrorResponse? {
        return try {
            throwable.response()?.errorBody()?.source()?.let {
                val moshiAdapter = Moshi.Builder().build().adapter(ErrorResponse::class.java)
                moshiAdapter.fromJson(it)
            }
        } catch (exception: Exception) {
            null
        }
    }
}
*/
    
    
    // we'll use this function in all
// repos to handle api errors.
    suspend fun <T> safeApiCall(apiToBeCalled: suspend () -> Response<T>): ResponseWrapper<T> {
        
        // Returning api response
        // wrapped in Resource class
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<T> = apiToBeCalled()
                
                if (response.isSuccessful) ResponseWrapper.Success(data = response.body()!!)
                else {
                    val errorResponse: ErrorResponse? = convertErrorBody(response.errorBody())
                    ResponseWrapper.Error(
                        errorMessage = errorResponse?.failureMessage ?: "Something went wrong"
                    )
                }
                
            } catch (e: HttpException) {
                ResponseWrapper.Error(errorMessage = e.message ?: "Something went wrong")
            } catch (e: IOException) {
                ResponseWrapper.Error("Please check your network connection")
            } catch (e: Exception) {
                ResponseWrapper.Error(errorMessage = "Something went wrong")
            }
        }
    }
    
    // If you don't wanna handle api's own
// custom error response then ignore this function
    private fun convertErrorBody(errorBody: ResponseBody?): ErrorResponse? {
        return try {
            errorBody?.source()?.let {
                val moshiAdapter = Moshi.Builder().build().adapter(ErrorResponse::class.java)
                moshiAdapter.fromJson(it)
            }
        } catch (exception: Exception) {
            null
        }
    }
}

