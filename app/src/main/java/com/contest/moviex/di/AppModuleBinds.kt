package com.contest.moviex.di

import android.app.Application
import com.contest.moviex.ImdbApp
import dagger.Binds
import dagger.Module

/**
 * Created by Manish Kumar
 */
@Module
abstract class AppModuleBinds {

    @Binds
    abstract fun provideApplication(bind: ImdbApp): Application
}