package com.practice.jazzhistorybookshelf.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IndustryIdentifier (
    val type: String,
    val identifier: String
)
