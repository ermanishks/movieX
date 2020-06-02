package com.contest.moviex.repo

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.WorkerParameters
import com.contest.moviex.dao.SearchTextDao
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

/**
 * Created by Manish Kumar
 *
 * worker to sync searched text with DB
 */

class SyncSearchTextsWithDbWorker  constructor(
    context: Context,
    params: WorkerParameters,
    dbManager: SearchTextDao
    ):CoroutineWorker(context,params){

    companion object {
        const val TAG = "SyncSearchTextsWithDbProgress"
        private const val PARAM_SEARCH_TEXT = "PARAM_SEARCH_TEXT"

        fun buildData(searchText: String) = Data.Builder()
            .putString(PARAM_SEARCH_TEXT, searchText)
            .build()
    }
    override suspend fun doWork(): Result {
        val searchText = inputData.getString(PARAM_SEARCH_TEXT)
        Log.d("MANISH", " worker running for $searchText")
        return Result.success()
    }

}