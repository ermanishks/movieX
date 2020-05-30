package com.contest.moviex.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.contest.moviex.repo.MovieRepository
import com.contest.moviex.ui.main.HomeViewModel

/**
 * Created by Manish Kumar
 */
class ViewModelFactory(private val movieRepository: MovieRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = HomeViewModel(movieRepository) as T
}
