package com.practice.jazzhistorybookshelf.data.network

import com.practice.jazzhistorybookshelf.models.JazzHistoryBook

sealed interface JazzHistoryBookResponse {
    object Loading : JazzHistoryBookResponse
    data class Success(val books: List<JazzHistoryBook>) : JazzHistoryBookResponse
    object Error : JazzHistoryBookResponse
}