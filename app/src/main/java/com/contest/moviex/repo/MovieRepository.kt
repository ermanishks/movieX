package com.contest.moviex.repo

import android.util.Log
import com.contest.moviex.extentions.buffer
import com.contest.moviex.model.ImdbSearchResultRes
import com.contest.moviex.model.ResultItemRes
import com.contest.moviex.network.NetworkService
import kotlinx.coroutines.flow.*
import kotlin.time.measureTime

/**
 * Created by Manish Kumar
 */
class MovieRepository  constructor(
    private val movieService: NetworkService
) {
    suspend fun getMovieDetailsByName(movieName:String):Flow<ResultItemRes>  {
        return flow{
            val resultRes = movieService.getSearchResults(movieName).results
            for(item in resultRes)
                emit(item)
        }.buffer(20).filter { it.titleType=="movie" }
    }

    companion object {
        // For Singleton instantiation
        @Volatile private var instance: MovieRepository? = null

        fun getInstance(movieService: NetworkService) =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(movieService).also { instance = it }
            }
    }

}