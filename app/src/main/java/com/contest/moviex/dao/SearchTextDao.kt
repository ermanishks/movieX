package com.contest.moviex.dao

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.*
import com.contest.moviex.model.SearchTextUI

/**
 * Created by Manish Kumar
 */
@Dao
abstract class SearchTextDao {

    @Query("SELECT * FROM search_texts")
    abstract  fun getPreviouslySearchTexts(): LiveData<List<SearchTextUI>>

    @Insert
    abstract suspend fun insert(entity: SearchKeyWordsEntity): Long

    @Insert
    abstract suspend fun insertAll(vararg entity: SearchKeyWordsEntity)

    @Insert
    abstract suspend fun insertAll(entities: List<SearchKeyWordsEntity>)

    @Update
    abstract suspend fun update(entity: SearchKeyWordsEntity)

    @Delete
    abstract suspend fun deleteEntity(entity: SearchKeyWordsEntity): Int

    @Transaction
    open suspend fun withTransaction(tx: suspend () -> Unit) = tx()

    suspend fun insertOrUpdate(entity: SearchKeyWordsEntity): Long {
        Log.d("MANISH","  id   ${entity.id}   title  ${entity.title}")
        return if (entity.id == 0L) {
            val id =  insert(entity)
            Log.d("MANISH"," id    $id")
            return  id
        } else {
            update(entity)
            entity.id
        }
    }

    @Transaction
    open suspend fun insertOrUpdate(entities: List<SearchKeyWordsEntity>) {
        entities.forEach {
            insertOrUpdate(it)
        }
    }
    companion object {
    }

}