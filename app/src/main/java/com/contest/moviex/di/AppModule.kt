package com.contest.moviex.di

import android.content.Context
import android.os.Build
import com.contest.moviex.ImdbApp
import com.contest.moviex.base.utils.AppCoroutineDispatchers
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

/**
 * Created by Manish Kumar
 */
@Module(includes = [AppModuleBinds::class])
class AppModule {
    @Provides
    fun provideContext(application: ImdbApp): Context = application.applicationContext

    @ApplicationId
    @Provides
    fun provideApplicationId(application: ImdbApp): String = application.packageName

    @Singleton
    @Provides
    fun provideCoroutineDispatchers() = AppCoroutineDispatchers(
        io = Dispatchers.IO,
        computation = Dispatchers.Default,
        main = Dispatchers.Main
    )

    @Singleton
    @Provides
    fun provideBackgroundExecutor(): Executor {
        val parallelism = (Runtime.getRuntime().availableProcessors() * 2)
            .coerceIn(4, 32)
        return if (Build.VERSION.SDK_INT < 24) {
            Executors.newFixedThreadPool(parallelism)
        } else {
            Executors.newWorkStealingPool(parallelism)
        }
    }
}