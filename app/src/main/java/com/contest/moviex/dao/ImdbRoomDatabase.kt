package com.contest.moviex.dao

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by Manish Kumar
 */

@Database(
    entities = [
    ImdbEntity::class
        ],
    version = 1)
abstract class ImdbRoomDatabase:RoomDatabase(),ImdbDatabase {
}