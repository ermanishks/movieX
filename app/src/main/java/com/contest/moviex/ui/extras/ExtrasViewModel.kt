package com.contest.moviex.ui.extras

import com.contest.moviex.base.BaseViewModel
import com.contest.moviex.db.AppDatabase
import javax.inject.Inject

/**
 * Created by Manish Kumar
 */
class ExtrasViewModel @Inject constructor(
    private val appDatabase: AppDatabase
) : BaseViewModel() {
}