package com.contest.moviex.dao

import androidx.room.*

/**
 * Created by Manish Kumar
 */
@Entity(tableName = "search_texts",
    indices = [
        Index(value = ["title_text"], unique = true)
    ]
)
data class SearchKeyWordsEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")  val id: Long = 0,
    @ColumnInfo(name = "title_text") val title: String? = null
    ) {
}