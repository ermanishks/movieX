package com.contest.moviex.di

import com.contest.moviex.base.ChildWorkerFactory
import com.contest.moviex.base.WorkerKey
import com.contest.moviex.repo.SyncSearchTextsWithDbWork
import com.contest.moviex.repo.SyncSearchTextsWithDbWorkImpl
import com.contest.moviex.ui.main.SyncAllSearchedTexts
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

/**
 * Created by Manish Kumar
 */
@Module
abstract class MovieModuleBinds {

    @Binds
    @IntoMap
    @WorkerKey(SyncAllSearchedTexts::class)
    abstract fun bindSyncAllSearchedTexts(factory: SyncAllSearchedTexts.Factory): ChildWorkerFactory


    @Binds
    @Singleton
    abstract fun provideImdbActions(bind: SyncSearchTextsWithDbWorkImpl): SyncSearchTextsWithDbWork
}