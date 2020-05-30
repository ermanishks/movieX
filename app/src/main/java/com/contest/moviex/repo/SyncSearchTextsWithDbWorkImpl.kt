package com.contest.moviex.repo

import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.contest.moviex.ui.main.SyncAllSearchedTexts
import javax.inject.Inject

class SyncSearchTextsWithDbWorkImpl @Inject constructor(
    private val workManager: WorkManager
) : SyncSearchTextsWithDbWork {
    override fun syncDbWithMovieTitle(titleText: String) {
        val request = OneTimeWorkRequest.Builder(SyncAllSearchedTexts::class.java)
            .addTag("SeacrhTextWithSyncDB")
            .setInputData(SyncSearchTextsWithDbWorker.buildData(titleText))
            .build()
        workManager.enqueue(request)
    }
}