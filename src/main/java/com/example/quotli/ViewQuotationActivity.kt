package com.example.quotli

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ViewQuotationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_quotation)

        // Set the toolbar as the app bar for the activity
        setSupportActionBar(findViewById(R.id.tb_viewQuotationToolbar))
        // Get a support ActionBar corresponding to this toolbar and enable the Up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}