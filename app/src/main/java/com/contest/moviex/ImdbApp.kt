package com.contest.moviex

import androidx.work.Configuration
import com.contest.moviex.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

/**
 * Created by Manish Kumar
 */
class ImdbApp:DaggerApplication(),Configuration.Provider{
    @Inject
    lateinit var workConfiguration: Configuration

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

    override fun getWorkManagerConfiguration(): Configuration= workConfiguration

}