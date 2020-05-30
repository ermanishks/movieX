package com.contest.moviex.network

import android.content.Context
import android.util.Log
import com.contest.moviex.model.ImdbSearchResultRes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Manish Kumar
 */
class NetworkService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://imdb8.p.rapidapi.com/title/")
        .client(CustomOkhttpClient.getOkhttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val imdbMovieService = retrofit.create(ImdbMovieService::class.java)

    suspend fun getSearchResults(queryName: String): ImdbSearchResultRes = withContext(Dispatchers.Default) {
        Log.d("MANISH","Current Thread  ${Thread.currentThread().name}  ")
        imdbMovieService.searchMovieByTitle(queryName)
    }

    interface ImdbMovieService {

        @GET("find")
        suspend fun searchMovieByTitle(@Query("q")  movieName:String) : ImdbSearchResultRes
    }
}