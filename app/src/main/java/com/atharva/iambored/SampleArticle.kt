package com.atharva.iambored

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article_table")
class SampleArticle(@PrimaryKey @ColumnInfo(name = "title") val title: String,
                    @ColumnInfo(name = "text") val text: String) {

     @ColumnInfo(name = "plink") val photoLink: String = ""
     @ColumnInfo(name = "alink") val articleLink: String = ""
     @ColumnInfo val category: String = ""

}