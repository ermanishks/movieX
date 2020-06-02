package com.contest.moviex.base

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.contest.moviex.dao.SearchTextDao
import com.contest.moviex.repo.SyncSearchTextsWithDbWorker
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * Created by Manish Kumar
 */
@Singleton
class ImdbWorkerFactory @Inject constructor(
    private val searchTextDao: SearchTextDao
) : WorkerFactory() {
    override fun createWorker(
        context: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return null
       /* return when(workerClassName) {
           null
            else ->
                // Return null, so that the base class can delegate to the default WorkerFactory.
                null
        }*/
    }
}