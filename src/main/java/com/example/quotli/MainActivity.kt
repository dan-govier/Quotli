package com.example.quotli

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

const val SOURCE_NAME = "for the source name"
const val QUOTATION_TEXT = "for the quotation text"
const val TAGS = "for the tags"

class MainActivity : AppCompatActivity() {

    private var quotesList = mutableListOf<Quotation>()
    private lateinit var rv_recyclerView : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set the toolbar as the app bar for the activity
        setSupportActionBar(findViewById(R.id.tb_mainToolbar))

        rv_recyclerView = findViewById<RecyclerView>(R.id.rv_recyclerView)

        // Create example quotations
        postExamples()

        // Set recycler view manager and adapter
        rv_recyclerView.layoutManager = LinearLayoutManager(this)
        rv_recyclerView.adapter = RecyclerAdapter(quotesList)

        // Set up Source Names Spinner
        val sp_sourceNames = findViewById<Spinner>(R.id.sp_source)
//        sp_sourceNames.layoutParams = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val sourceNames = mutableListOf<String>()
        quotesList.forEach { e -> sourceNames.add(e.source.toString())}
        val sourceArrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sourceNames)
        sp_sourceNames.adapter = sourceArrayAdapter

        // Set up Tags Spinner
        val sp_tags = findViewById<Spinner>(R.id.sp_tags)
//        sp_tags.layoutParams = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val tags = mutableListOf<String>()
        quotesList.forEach { e -> tags.add(e.getTagsAsSingleString()!!)}
        val tagsArrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tags)
        sp_tags.adapter = tagsArrayAdapter

        sp_sourceNames.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, quotesList[position].source, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Code to perform some action when nothing is selected
            }
        }

        sp_tags.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, quotesList[position].getTagsAsSingleString(), Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Code to perform some action when nothing is selected
            }
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.itemId) {
        R.id.action_addQuotation -> {

            // User chose the "Add Quotation" item, switch to the activity_add_quotation activity
            val intent = Intent(this, AddQuotationActivity::class.java)
            startActivityForResult(intent, 0)

            true
        }
        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
                addToList(
                    data?.getStringExtra(SOURCE_NAME),
                    data?.getStringExtra(QUOTATION_TEXT),
                    data?.getStringExtra(TAGS))
//                Toast.makeText(applicationContext, data?.getStringExtra(SOURCE_NAME),Toast.LENGTH_SHORT).show()
            }
        rv_recyclerView.adapter?.notifyDataSetChanged()
    }


    private fun addToList(source: String?, quotation: String?, tags: String?) {
        // Create a new Quotation and add it to the list
        val newQuotation = Quotation(source, quotation, tags?.split(",")?.map {it.trim()})
        quotesList.add(newQuotation)
    }

    private fun postExamples() {
        for (i in 1..10) {
            addToList("Source $i", "Quote $i", "Tags, $i, $i+1")
        }
    }


}