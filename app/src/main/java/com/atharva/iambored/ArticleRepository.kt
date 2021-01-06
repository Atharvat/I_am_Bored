package com.atharva.iambored

import androidx.lifecycle.LiveData

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class ArticleRepository(private val articleDao: ArticleDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allArticles: LiveData<List<SampleArticle>> = articleDao.getAlphabetizedWords()

    suspend fun insert(sampleArticle: SampleArticle) {
        articleDao.insert(sampleArticle)
    }
}