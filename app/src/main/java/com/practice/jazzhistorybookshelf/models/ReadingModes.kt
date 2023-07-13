package com.practice.jazzhistorybookshelf.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReadingModes (
    val text: Boolean,
    val image: Boolean
)