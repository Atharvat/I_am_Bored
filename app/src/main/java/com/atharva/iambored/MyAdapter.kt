package com.atharva.iambored

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter( private val myDataset: ArrayList<SampleArticle>, context: Context)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(val cardView: CardView) : RecyclerView.ViewHolder(cardView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val cardView = LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_element, parent, false) as CardView
        return MyViewHolder(cardView)
    }

    override fun getItemCount() = myDataset.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //check if index should be 0 or 1
        val linearLayout: LinearLayout = (holder.cardView.getChildAt(0) as LinearLayout)
        (linearLayout.getChildAt(1) as TextView).text = myDataset[position].title
        (linearLayout.getChildAt(2) as TextView).text = myDataset[position].text
       // (holder.cardView.getChildAt(2) as ImageView).setImageResource() = myDataset[position].photoLink
    }

}


