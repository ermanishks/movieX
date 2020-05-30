package com.contest.moviex.dao

import androidx.room.withTransaction
import javax.inject.Inject

/**
 * Created by Manish Kumar
 */
class RoomTransactionRunner @Inject constructor(
    private val db: ImdbRoomDatabase
) : DatabaseTransactionRunner {
    override suspend operator fun <T> invoke(block: suspend () -> T): T {
        return db.withTransaction {
            block()
        }
    }
}
