package com.contest.moviex.dao

import android.content.Context
import android.os.Debug
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Manish Kumar
 */

@Module(
    includes = [
        RoomDatabaseModule::class,
        DatabaseModuleBinds::class,
        DatabaseDaoModule::class
    ]
)
class DatabaseModule

@Module
class RoomDatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(context: Context): ImdbRoomDatabase {
        val builder =
            Room.databaseBuilder(context, ImdbRoomDatabase::class.java, "searched_text.db")
                .fallbackToDestructiveMigration()
        if (Debug.isDebuggerConnected()) {
            builder.allowMainThreadQueries()
        }
        return builder.build()
    }
}

@Module
class DatabaseDaoModule {
    @Provides
    fun provideSearchTextDao(db: ImdbDatabase) = db.searchtextDao()
}

@Module
abstract class DatabaseModuleBinds {
    @Binds
    abstract fun bindImdbDatabase(context: ImdbRoomDatabase): ImdbDatabase

    @Singleton
    @Binds
    abstract fun provideDatabaseTransactionRunner(runner: RoomTransactionRunner): DatabaseTransactionRunner
}
