package com.contest.moviex.ui.main

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.contest.moviex.base.ChildWorkerFactory
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

/**
 * Created by Manish Kumar
 */


class SyncAllSearchedTexts @AssistedInject constructor(
    @Assisted params: WorkerParameters,
    @Assisted context: Context
) : CoroutineWorker(context, params) {


    override suspend fun doWork(): Result {
    Log.d("MANISH"," worker running ....")
        return Result.success()
    }
    @AssistedInject.Factory
    interface Factory : ChildWorkerFactory
}