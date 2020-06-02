package com.contest.moviex.di

import com.contest.moviex.ImdbApp
import com.contest.moviex.di.modules.ActivityModule
import com.contest.moviex.di.modules.AppModule

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityModule::class,
    AppModule::class
])
interface AppComponent: AndroidInjector<ImdbApp> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: ImdbApp): AppComponent
    }
}