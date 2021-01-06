package com.atharva.iambored

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ArticleDao {

    @Query("SELECT * from article_table ORDER BY title ASC")
    fun getAlphabetizedWords(): LiveData<List<SampleArticle>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(title: SampleArticle)

    @Query("DELETE FROM article_table")
    suspend fun deleteAll()

}