package com.contest.moviex

import androidx.lifecycle.MutableLiveData
import com.contest.moviex.base.BaseViewModel
import com.contest.moviex.base.utils.AppCoroutineDispatchers
import com.squareup.inject.assisted.AssistedInject

/**
 * Created by Manish Kumar
 */
class MainViewModel @AssistedInject constructor(
    override val dispatchers: AppCoroutineDispatchers
):BaseViewModel() {

    var searchText = MutableLiveData<String>()


}