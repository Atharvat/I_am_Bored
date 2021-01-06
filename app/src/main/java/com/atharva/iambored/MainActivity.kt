package com.atharva.iambored

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rview)

        var myList = ArrayList<SampleArticle>()

        myList.add(SampleArticle("Sample Title 1", "Sample text 1"))
        myList.add( SampleArticle("Sample Title 2", "Sample text 2"))

        /*var myDataset = arrayOf(
                SampleArticle("Sample Title 1", "Sample text 1")  ,
                SampleArticle("Sample Title 2", "Sample text 2")
        )*/

        linearLayoutManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(myList, this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = viewAdapter


    }
}