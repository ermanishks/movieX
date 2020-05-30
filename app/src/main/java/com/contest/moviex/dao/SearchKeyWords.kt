package com.contest.moviex.dao

import androidx.room.*

/**
 * Created by Manish Kumar
 */
@Entity(tableName = "search_texts",
    indices = [
        Index(value = ["titile_text"], unique = true)
    ]
)
data class SearchKeyWords(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")  override val id: Long = 0,
    @ColumnInfo(name = "title_text") val title: String? = null
    ):ImdbEntity {
}