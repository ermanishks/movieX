package com.contest.moviex.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.contest.moviex.dao.SearchKeyWordsEntity
import com.contest.moviex.dao.SearchTextDao

/**
 * Created by Manish Kumar
 */

/**
 * The [Room] database for this app.
 */
@Database(entities = [
    SearchKeyWordsEntity::class
],
    version = 1,
    exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun searchTextsDao(): SearchTextDao

    companion object {
        private const val databaseName = "searched_text.db"

        fun buildDatabase(context: Context): AppDatabase {
            // Since Room is only used for FTS, destructive migration is enough because the tables
            // are cleared every time the app launches.
            // https://medium.com/androiddevelopers/understanding-migrations-with-room-f01e04b07929
            return Room.databaseBuilder(context, AppDatabase::class.java, databaseName)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}