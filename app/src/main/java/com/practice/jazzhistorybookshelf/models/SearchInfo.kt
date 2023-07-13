package com.practice.jazzhistorybookshelf.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchInfo (
    val textSnippet: String
)