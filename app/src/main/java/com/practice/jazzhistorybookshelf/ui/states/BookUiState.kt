package com.practice.jazzhistorybookshelf.ui.states

import com.practice.jazzhistorybookshelf.models.JazzHistoryBook

sealed interface BookUiState {
    object Loading : BookUiState
    data class Success(val book: JazzHistoryBook) : BookUiState
    object Error : BookUiState
}