package com.example.quotli

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class AddQuotationActivity : AppCompatActivity() {

    lateinit var et_sourceName : EditText
    lateinit var et_quotationText : EditText
    lateinit var et_tags : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_quotation)

        // Set the toolbar as the app bar for the activity
        setSupportActionBar(findViewById(R.id.tb_addQuotationToolbar))
        // Get a support ActionBar corresponding to this toolbar and enable the Up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        et_sourceName = findViewById<EditText>(R.id.et_sourceName)
        et_quotationText = findViewById<EditText>(R.id.et_quotationText)
        et_tags = findViewById<EditText>(R.id.et_tags)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_quotation_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.itemId) {
        R.id.action_confirm -> {
            // User chose the "Confirm Entry" item, switch to the activity_add_quotation activity

            val data = Intent().apply{
                putExtra(SOURCE_NAME, et_sourceName.text)
                putExtra(QUOTATION_TEXT, et_quotationText.text)
                putExtra(TAGS,et_tags.text)
            }
            setResult(Activity.RESULT_OK, data)
            finish()

            true
        }
        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }


    }
}