package com.example.quotli

class Quotation(var source: String,var quotation: String, private var tags: List<String>) {

    fun getTagsAsSingleString(): String {
        return tags.joinToString(
                limit = 3,
                truncated = "..."
        )
    }
}