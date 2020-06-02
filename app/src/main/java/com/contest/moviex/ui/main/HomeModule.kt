package com.contest.moviex.ui.main

import androidx.lifecycle.ViewModel
import com.contest.moviex.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by Manish Kumar
 */
@Module
@Suppress("UNUSED")
internal abstract class HomeModule {

    /**
     * Generates an [AndroidInjector] for the [FeedFragment] as a Dagger subcomponent of the
     * [MainModule].
     */
    @ContributesAndroidInjector
    internal abstract fun contributeFeedFragment(): HomeFragment

    /**
     * The ViewModels are created by Dagger in a map. Via the @ViewModelKey, we define that we
     * want to get a [FeedViewModel] class.
     */
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}