package com.contest.moviex.di.modules

import android.content.Context
import com.contest.moviex.ImdbApp
import com.contest.moviex.db.AppDatabase
import com.contest.moviex.di.viewmodel.ViewModelModule

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Rupesh on 5/8/2019.
 */

@Module(
    includes = [
        (ViewModelModule::class)
    ]
)
class AppModule {

    @Provides
    fun provideContext(application: ImdbApp): Context {
        return application.applicationContext
    }
    @Singleton
    @Provides
    fun providesAppDatabase(context: Context): AppDatabase = AppDatabase.buildDatabase(context)
}