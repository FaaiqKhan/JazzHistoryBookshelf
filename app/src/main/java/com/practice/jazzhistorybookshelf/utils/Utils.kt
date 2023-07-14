package com.practice.jazzhistorybookshelf.utils

object Utils {
    fun createImageUrl(imageData: String?): String? {
        return imageData?.replace("http:", "https:")
    }
}