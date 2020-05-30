package com.contest.moviex.base

import androidx.lifecycle.ViewModel
import com.contest.moviex.base.utils.AppCoroutineDispatchers

/**
 * Created by Manish Kumar
 */
abstract class BaseViewModel: ViewModel() {
    protected abstract val dispatchers: AppCoroutineDispatchers

}

