package com.practice.jazzhistorybookshelf.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PDF (
    val isAvailable: Boolean,
    val acsTokenLink: String?
)