package com.practice.jazzhistorybookshelf.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JazzHistoryBook (
    val kind: String,
    val id: String,
    val etag: String?,
    val selfLink: String,
    val volumeInfo: VolumeInfo,
    val saleInfo: SaleInfo?,
    val accessInfo: AccessInfo?,
    val searchInfo: SearchInfo?
)

data class JazzHistoryBooks(
    val kind: String,
    val totalItems: Int,
    val items: List<JazzHistoryBook>
)