package com.example.quotli

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var sourcesList = mutableListOf<String>()
    private var quotesList = mutableListOf<String>()
    private var tagsList = mutableListOf<String>()

    private var rv_recyclerView = findViewById<RecyclerView>(R.id.rv_recyclerView)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postExamples()

        rv_recyclerView.layoutManager = LinearLayoutManager(this)
        rv_recyclerView.adapter = RecyclerAdapter(sourcesList, quotesList, tagsList)
    }



    private fun addToList(source: String, quote: String, tags: String) {
        sourcesList.add(source)
        quotesList.add(quote)
        tagsList.add(tags)
    }

    private fun postExamples() {
        for (i in 1..5) {
            addToList("Source $i", "Quote $i", "Tags $i")
        }
    }


}