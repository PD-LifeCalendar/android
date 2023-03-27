package com.example.lifecalendar.data.util

import android.util.Log
import com.example.lifecalendar.data.source.local.prefs.SessionManager
import com.example.lifecalendar.data.source.remote.model.LoginResponse
import com.example.lifecalendar.domain.model.ErrorResponse
import com.example.lifecalendar.domain.model.ResultWrapper
import com.example.lifecalendar.domain.usecase.RefreshTokenUseCase
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

abstract class SafeApiCall {

    suspend fun <T> safeApiCall(apiToBeCalled: suspend () -> Response<T>): ResultWrapper<T> {

        return withContext(Dispatchers.IO) {
            try {
                val response: Response<T> = apiToBeCalled()

                if (response.isSuccessful) ResultWrapper.Success(data = response.body()!!, cookies = response.headers().get("Set-Cookie").toString())
                else {
                    val errorResponse: ErrorResponse? = convertErrorBody(response.errorBody())
                    ResultWrapper.Error(
                        errorMessage = errorResponse?.failureMessage ?: "Something went wrong"
                    )
                }

            } catch (e: HttpException) {
                ResultWrapper.Error(errorMessage = e.message ?: "Something went wrong")
            } catch (e: IOException) {
                ResultWrapper.Error("Please check your network connection")
            } catch (e: Exception) {
                ResultWrapper.Error(errorMessage = "Something went wrong")
            }
        }
    }
}


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


