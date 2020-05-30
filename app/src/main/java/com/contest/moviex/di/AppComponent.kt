package com.contest.moviex.di

import com.contest.moviex.ImdbApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Manish Kumar
 */

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    MovieModule::class
        ])
interface AppComponent: AndroidInjector<ImdbApp> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: ImdbApp): AppComponent
    }
}
