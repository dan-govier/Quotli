package com.example.quotli

class Quotation(source: String, quotation: String, private var tags: List<String>) {

    fun getTagsAsSingleString(): String {
        return tags.joinToString(
                limit = 3,
                truncated = "..."
        )
    }
}