package com.example.lifecalendar.di

import com.example.lifecalendar.data.source.remote.LifeCalendarService
import com.example.lifecalendar.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
class NetworkModule {
    
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
    
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
//            .cookieJar(MyCookieJar())
            .cookieJar(object : CookieJar {
                private val cookieStore: HashMap<HttpUrl, List<Cookie>> = HashMap()
                override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
                    cookieStore[url] = cookies
                }
        
                override fun loadForRequest(url: HttpUrl): List<Cookie> {
                    val cookies = cookieStore[url]
                    return cookies ?: ArrayList()
                }
            })
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