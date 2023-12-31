package com.practice.jazzhistorybookshelf.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PanelizationSummary (
    val containsEpubBubbles: Boolean,
    val containsImageBubbles: Boolean
)