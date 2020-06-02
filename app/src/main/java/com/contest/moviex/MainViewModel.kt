package com.contest.moviex

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.contest.moviex.base.BaseViewModel
import com.contest.moviex.base.Resource
import com.contest.moviex.dao.SearchKeyWordsEntity
import com.contest.moviex.db.AppDatabase
import com.contest.moviex.model.ResultItemRes
import com.contest.moviex.model.SearchTextUI
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Error
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * Created by Manish Kumar
 */
class MainViewModel @Inject constructor(
    private val appDatabase: AppDatabase
) : BaseViewModel() {

    private val dbUpdateStatus = MutableLiveData<Resource<Any>>()
    private val exceptionHandler = CoroutineExceptionHandler {   context, exception ->
        dbUpdateStatus.postValue(Resource.error("something went wrong",exception))
    }
    var searchText = MutableLiveData<String>()

    fun syncSearchTextWithDB(searchedMovie: String) {
        if (!searchedMovie.isBlank()) {
            viewModelScope.launch(exceptionHandler) {
                appDatabase.searchTextsDao()
                    .insertOrUpdate(entity = SearchKeyWordsEntity(title = searchedMovie))
            }
        }
    }
    val list  : LiveData<List<SearchTextUI>>
        get() = appDatabase.searchTextsDao().getPreviouslySearchTexts()


}