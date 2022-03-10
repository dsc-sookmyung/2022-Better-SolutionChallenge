package com.example.forme_empty.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.forme_empty.R
import com.example.forme_empty.model.ForMe

class RecordPageAdapter (private val context: Context, private val dataset: List<ForMe>) : RecyclerView.Adapter<RecordPageAdapter.ItemViewHolder>() {

        class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.record_text)
        val imageView: ImageView = view.findViewById(R.id.record_image)
        //val background: ImageView = view.findViewById(R.id.record_background)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.record_page_list_view, parent, false)
        return ItemViewHolder(adapterLayout)
    }


    override fun getItemCount() = dataset.size

/*
    override fun onBindViewHolder(holder: RecordItemAdapter.ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
        //holder.background.setImageResource(item.imageResourceId)
    }
*/

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }
}