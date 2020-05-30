package com.contest.moviex.di

import android.content.Context
import androidx.work.Configuration
import androidx.work.WorkManager
import com.contest.moviex.base.ImdbWorkerFactory
import dagger.Module
import dagger.Provides
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Singleton

/**
 * Created by Manish Kumar
 */
@Module(includes = [MovieModuleBinds::class])
class MovieModule  {
    @Provides
    @Singleton
    fun provideWorkManager(context: Context): WorkManager = WorkManager.getInstance(context)

    @Provides
    @ProcessLifetime
    fun provideWorkConfiguration(workerFactory: ImdbWorkerFactory): Configuration {
        return Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.DEBUG)
            .setWorkerFactory(workerFactory)
            .build()
    }
}
