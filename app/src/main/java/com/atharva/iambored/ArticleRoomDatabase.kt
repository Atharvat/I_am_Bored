package com.atharva.iambored

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = [SampleArticle::class], version = 1, exportSchema = false)
public abstract class ArticleRoomDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao

    private class ArticleDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.articleDao())
                }
            }
        }

        suspend fun populateDatabase(articleDao: ArticleDao) {
            // Delete all content here.
            articleDao.deleteAll()

            // Add sample articles.
            var article = SampleArticle("Hello","Sample text, just for populating")
            articleDao.insert(article)
            article = SampleArticle("World!", "Sample text, just for populating")
            articleDao.insert(article)

            // TODO: Add your own articles!
        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ArticleRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ArticleRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ArticleRoomDatabase::class.java,
                    "article_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}

