package com.practice.jazzhistorybookshelf.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageLinks (
    val smallThumbnail: String,
    val thumbnail: String
)