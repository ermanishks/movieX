package com.contest.moviex.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.contest.moviex.base.BaseViewModel
import com.contest.moviex.base.Resource
import com.contest.moviex.base.utils.AppCoroutineDispatchers
import com.contest.moviex.model.ImdbSearchResultRes
import com.contest.moviex.model.ResultItemRes
import com.contest.moviex.repo.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

/**
 * Created by Manish Kumar
 */
class HomeViewModel constructor(
    private val movieRepository: MovieRepository, override val dispatchers: AppCoroutineDispatchers
) :BaseViewModel(){
    private val movieDetail = MutableLiveData<Resource<List<ResultItemRes>>>()

    val movieInfo: LiveData<Resource<List<ResultItemRes>>>
        get() = movieDetail

    val res = arrayListOf<ResultItemRes>()
    fun searchMovie(movie: String) {
        viewModelScope.launch {
            movieDetail.postValue(Resource.loading(null))
            try {
                res.clear()
                movieRepository.getMovieDetailsByName(movie).buffer(20).collect {
                    res.add(it)
                }
                movieDetail.postValue(Resource.success(res))
            } catch (e: Exception) {
                movieDetail.postValue(Resource.error("Something Went Wrong", null))
            }
        }
    }
}