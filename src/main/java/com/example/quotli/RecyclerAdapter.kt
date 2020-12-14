package com.example.quotli

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter (private var quotations: List<Quotation>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
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

//                val intent = Intent(this, AddQuotationActivity::class.java)
//                startActivityForResult(intent, 0)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemSource.text = quotations[position].source
        holder.itemQuote.text = quotations[position].quotation
        holder.itemTags.text = quotations[position].getTagsAsSingleString()

    }

    override fun getItemCount(): Int {
        return quotations.size
    }
}