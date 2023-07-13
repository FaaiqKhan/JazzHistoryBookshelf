package com.practice.jazzhistorybookshelf.states

sealed interface JazzHistoryBookUiState {
    object Loading : JazzHistoryBookUiState
    data class Success(val result: String) : JazzHistoryBookUiState
    object Error : JazzHistoryBookUiState
}