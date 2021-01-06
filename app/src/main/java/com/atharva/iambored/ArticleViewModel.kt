package com.atharva.iambored

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArticleViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ArticleRepository
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allArticles: LiveData<List<SampleArticle>>

    init {
        val articlesDao = ArticleRoomDatabase.getDatabase(application, viewModelScope).articleDao()
        repository = ArticleRepository(articlesDao)
        allArticles = repository.allArticles
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(sampleArticle: SampleArticle) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(sampleArticle)
    }
}