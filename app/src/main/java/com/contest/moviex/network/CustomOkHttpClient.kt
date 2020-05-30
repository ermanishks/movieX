package com.contest.moviex.network

/**
 * Created by Manish Kumar
 */

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * Created by Manish Kumar
 */
// singleton
object CustomOkhttpClient {

    private val readTimeOut = 30L // in seconds
    private val connectTimeOut = 30L // in seconds
    private val api_key = "91aa27e5ebmsh6f596b78515b5a3p1da929jsn0b9134c05ad9"
    private val api_host = "imdb8.p.rapidapi.com"

    val cacheSize = (5 * 1024 * 1024).toLong()


    fun getOkhttpClient(): OkHttpClient {
        val interceptors = arrayListOf<Interceptor>()
        val loggingInterceptorBody = HttpLoggingInterceptor()
        loggingInterceptorBody.level = HttpLoggingInterceptor.Level.BODY

        val headerInterceptor = object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                requestBuilder.header("x-rapidapi-host", api_host)
                requestBuilder.header("x-rapidapi-key", api_key)

                val request = requestBuilder.build()
                return chain.proceed(request)
            }
        }
        val cacheInterceptor = object :Interceptor{
            override fun intercept(chain: Interceptor.Chain): Response {
                var request = chain.request()
                return chain.proceed(request)
            }
        }
        interceptors.add(cacheInterceptor)
        interceptors.add(headerInterceptor)
        interceptors.add(loggingInterceptorBody)

        val clientBuilder = OkHttpClient.Builder()
            .readTimeout(readTimeOut, TimeUnit.SECONDS)
            .connectTimeout(connectTimeOut, TimeUnit.SECONDS)

        interceptors.forEach { interceptor ->
            clientBuilder.addInterceptor(interceptor)
        }
        return clientBuilder.build()
    }
}