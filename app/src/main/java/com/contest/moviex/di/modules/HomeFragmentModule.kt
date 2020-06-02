package com.contest.moviex.di.modules

import com.contest.moviex.di.scopes.PerFragment
import com.contest.moviex.ui.extras.ExtrasFragment
import com.contest.moviex.ui.main.HomeFragment
import com.contest.moviex.ui.tvshows.TvShowsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal abstract class HomeFragmentModule {

    @ContributesAndroidInjector
    @PerFragment
    abstract fun tabsParentFragment(): HomeFragment

    @ContributesAndroidInjector
    @PerFragment
    abstract fun tvshowsFragment(): TvShowsFragment

    @ContributesAndroidInjector
    @PerFragment
    abstract fun extrasFragment(): ExtrasFragment

}