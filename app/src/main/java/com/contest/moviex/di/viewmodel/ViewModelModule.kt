package com.contest.moviex.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.contest.moviex.MainViewModel
import com.contest.moviex.ui.extras.ExtrasViewModel
import com.contest.moviex.ui.main.HomeViewModel
import com.contest.moviex.ui.tvshows.TvShowsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    /**
     * Bind all the view models here
     */

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindsBranchListViewModel(branchListViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun homeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TvShowsViewModel::class)
    internal abstract fun tvShowsViewModel(homeViewModel: TvShowsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ExtrasViewModel::class)
    internal abstract fun extrasViewModel(homeViewModel: ExtrasViewModel): ViewModel



}