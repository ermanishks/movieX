package com.contest.moviex.di.modules


import com.contest.moviex.MainActivity
import com.contest.moviex.di.scopes.ActivityScope
import com.contest.moviex.ui.tvshows.TvShowsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    @ActivityScope
    abstract fun homeActivity(): MainActivity


}