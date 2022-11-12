package com.example.lifecalendar.di

import android.content.Context
import com.example.lifecalendar.data.source.remote.LifeCalendarService
import com.example.lifecalendar.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {
    
    @Provides
    fun provideRetrofitInstance(context: Context): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        
        val cache = Cache(directory = context.cacheDir, maxSize = 10L * 1024 * 1024) // 10 Mb
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .cache(cache)
            .build()
        
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    
    @Provides
    fun provideRetrofitService(retrofit: Retrofit): LifeCalendarService {
        return retrofit.create(LifeCalendarService::class.java)
    }
}