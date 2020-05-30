package com.contest.moviex.dao

import androidx.room.*
import com.contest.moviex.model.SearchTextUI

/**
 * Created by Manish Kumar
 */
@Dao
abstract class SearchTextDao: EntityDao<ImdbEntity>() {
    @Query("SELECT * FROM search_texts")
    abstract suspend fun getPreviouslySearchTexts(id: Int): SearchTextUI?

    companion object {
    }

}