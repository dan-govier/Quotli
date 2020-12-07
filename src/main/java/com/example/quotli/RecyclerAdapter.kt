package com.example.quotli

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter (private var sources: List<String>, private var quotes: List<String>, private var tags: List<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemSource: TextView = itemView.findViewById(R.id.tv_source)
        val itemQuote: TextView = itemView.findViewById(R.id.tv_quote)
        val itemTags: TextView = itemView.findViewById(R.id.tv_tags)

        init {
            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                Toast.makeText(
                    itemView.context,
                    "You clicked on item # ${position + 1}",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemSource.text = sources[position]
        holder.itemQuote.text = quotes[position]
        holder.itemTags.text = tags[position]

    }

    override fun getItemCount(): Int {
        return sources.size
    }
}