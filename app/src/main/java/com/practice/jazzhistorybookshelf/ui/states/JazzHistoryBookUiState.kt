package com.practice.jazzhistorybookshelf.ui.states

import com.practice.jazzhistorybookshelf.models.JazzHistoryBook

sealed interface JazzHistoryBookUiState {
    object Loading : JazzHistoryBookUiState
    data class Success(val books: List<JazzHistoryBook>) : JazzHistoryBookUiState
    object Error : JazzHistoryBookUiState
}