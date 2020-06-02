package com.contest.moviex.repo

import com.contest.moviex.extentions.buffer
import com.contest.moviex.model.ResultItemRes
import com.contest.moviex.network.NetworkService
import kotlinx.coroutines.flow.*

/**
 * Created by Manish Kumar
 */
class MovieRepository  constructor(
    private val movieService: NetworkService
) {
    /// no need to mark this method as suspend
    fun getMovieDetailsByName(movieName:String):Flow<ResultItemRes>  {
        return flow{
            // code inside the flow { ... } builder block can suspend.
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