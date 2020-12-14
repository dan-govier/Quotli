package com.example.quotli

import java.io.Serializable

class Quotation(var source: String?, var quotation: String?, private var tags: List<String>?) : Serializable {

    fun getTagsAsSingleString(): String? {
        return tags?.joinToString(
            limit = 3,
            truncated = "..."
        )
    }
}