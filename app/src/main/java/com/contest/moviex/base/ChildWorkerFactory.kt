package com.contest.moviex.base

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters

/**
 * Created by Manish Kumar
 */
interface ChildWorkerFactory {
    fun create(context: Context, params: WorkerParameters): ListenableWorker
}