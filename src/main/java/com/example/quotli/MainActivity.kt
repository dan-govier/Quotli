package com.example.quotli

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var quotesList = mutableListOf<Quotation>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv_recyclerView = findViewById<RecyclerView>(R.id.rv_recyclerView)


        postExamples()

        rv_recyclerView.layoutManager = LinearLayoutManager(this)
        rv_recyclerView.adapter = RecyclerAdapter(quotesList)
    }



    private fun addToList(source: String, quotation: String, tags: String) {
        // Create a new Quotation and add it to the list
        val newQuotation = Quotation(source, quotation, tags.split(",").map {it.trim()})
        quotesList.add(newQuotation)
    }

    private fun postExamples() {
        for (i in 1..10) {
            addToList("Source $i", "Quote $i", "Tags, $i, $i+1")
        }
    }


}