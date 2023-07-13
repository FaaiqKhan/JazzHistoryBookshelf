package com.practice.jazzhistorybookshelf.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SaleInfo (
    val country: String,
    val saleability: String,
    val isEbook: Boolean
)